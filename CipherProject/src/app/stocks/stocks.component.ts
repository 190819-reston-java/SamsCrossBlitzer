import { Component, OnInit } from  '@angular/core';
import { FinancialNewsInterface } from "../FinancialNewsInterface";
import { NewsService } from '../news.service';
import { FinancialPricingInterface } from '../FinancialPricingInterface';
import { PricingDataService } from '../pricing.service';

@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.css']
})
export class StocksComponent implements OnInit {

  constructor(private pricingData : PricingDataService, private newsData : NewsService) { }

  ticker : string;
  post : FinancialPricingInterface[];
  postNews : FinancialNewsInterface[];

  ngOnInit() {   
    this.pricingData.getPrices("AMZN").subscribe(post => {
      this.post  = post;
    })
      
      this.newsData.getNews("AMZN").subscribe(postNews => {
      this.postNews  = postNews;  
      })

    }
  }