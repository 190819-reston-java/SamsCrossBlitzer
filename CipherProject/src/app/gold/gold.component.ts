import { Component, OnInit } from  '@angular/core';
import {PricingDataService} from '../pricing.service';
import {FinancialPricingInterface} from '../FinancialPricingInterface'
import { NewsService } from '../news.service';
import { FinancialNewsInterface } from '../FinancialNewsInterface';
import { Observable } from 'rxjs/Observable';
import { AuthService } from './../auth/auth.service';

@Component({
  selector: 'app-gold',
  templateUrl: './gold.component.html',
  styleUrls: ['./gold.component.css']
})
export class GoldComponent implements OnInit {

  isLoggedIn$: Observable<boolean>; 

  constructor(private pricingData : PricingDataService, private newsData : NewsService, private authService: AuthService) { }

  post : FinancialPricingInterface[];
  postNews : FinancialNewsInterface[];

  ngOnInit() {   
    this.pricingData.getPrices("GLD").subscribe(post => {
      this.post  = post;
    })
      
      this.newsData.getNews("GLD").subscribe(postNews => {
      this.postNews  = postNews;  
      })

      this.isLoggedIn$ = this.authService.isLoggedIn;

    }
  }


