import { Component, OnInit } from  '@angular/core';
import {PricingDataService} from '../pricing.service';
import {FinancialPricingInterface} from '../FinancialPricingInterface'
import { FinancialNewsInterface } from '../FinancialNewsInterface';
import { NewsService } from '../news.service';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-oil',
  templateUrl: './oil.component.html',
  styleUrls: ['./oil.component.css']
})
export class OilComponent implements OnInit {

  constructor(private pricingData : PricingDataService, private newsData : NewsService,private authService: AuthService) { }
  isLoggedIn$: Observable<boolean>;  
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