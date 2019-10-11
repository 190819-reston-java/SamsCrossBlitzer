import { Component, OnInit } from  '@angular/core';
import {PricingDataService} from '../pricing.service';
import { HttpClient } from '@angular/common/http';
import {FinancialNewsService, DataEntity} from '../FinancialNewsInterface';
import { NewsService } from '../news.service';
import { FinancialPricingInterface } from '../FinancialPricingInterface';

@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.css']
})
export class StocksComponent implements OnInit {

  post : FinancialNewsService[];

  constructor(private newsData : NewsService, 
    private pricingData : PricingDataService) { }

  
  ngOnInit() {   
    this.newsData.getNews().subscribe(post => {
      this.post  = post;
    }) 

  }
}