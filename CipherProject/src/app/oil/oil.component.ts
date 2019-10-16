import { Component, OnInit } from  '@angular/core';
import {PricingDataService} from '../pricing.service';
import {FinancialPricingInterface} from '../FinancialPricingInterface'
import { FinancialNewsInterface } from '../FinancialNewsInterface';
import { NewsService } from '../news.service';
import { Observable } from 'rxjs/Observable';
import { AuthService } from './../auth/auth.service';

@Component({
  selector: 'app-oil',
  templateUrl: './oil.component.html',
  styleUrls: ['./oil.component.css']
})
export class OilComponent implements OnInit {

  isLoggedIn$: Observable<boolean>;  

  constructor(private pricingData : PricingDataService, private newsData : NewsService, private authService: AuthService) { }

  post : FinancialPricingInterface[];
  postNews : FinancialNewsInterface[];

  ngOnInit() { 
    this.isLoggedIn$ = this.authService.isLoggedIn;
    
    this.pricingData.getPrices("USO").subscribe(post => {
      this.post  = post;
    })
      
      this.newsData.getNews("USO").subscribe(postNews => {
      this.postNews  = postNews;  
      })

    }
}