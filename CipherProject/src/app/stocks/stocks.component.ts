import { Component, OnInit } from  '@angular/core';
import { FinancialNewsInterface } from "../FinancialNewsInterface";
import { NewsService } from '../news.service';
import { FinancialPricingInterface } from '../FinancialPricingInterface';
import { PricingDataService } from '../pricing.service';
import { Observable } from 'rxjs/Observable';
import { AuthService } from './../auth/auth.service';

@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.css']
})
export class StocksComponent implements OnInit {

  isLoggedIn$: Observable<boolean>;

  constructor(private pricingData : PricingDataService, private newsData : NewsService, private authService: AuthService) { }

  ticker : string;
  post : FinancialPricingInterface[];
  postNews : FinancialNewsInterface[];

  ngOnInit() { 
    this.isLoggedIn$ = this.authService.isLoggedIn;
    
    this.pricingData.getPrices("AMZN").subscribe(post => {
      this.post  = post;
    })
      
      this.newsData.getNews("AMZN").subscribe(postNews => {
      this.postNews  = postNews;  
      })

    }
  }