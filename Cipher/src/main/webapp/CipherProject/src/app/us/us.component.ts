import { Component, OnInit } from '@angular/core';
import { FinancialPricingInterface } from '../FinancialPricingInterface';
import { FinancialNewsInterface } from '../FinancialNewsInterface';
import { PricingDataService } from '../pricing.service';
import { NewsService } from '../news.service';

@Component({
  selector: 'app-us',
  templateUrl: './us.component.html',
  styleUrls: ['./us.component.css']
})
export class USComponent implements OnInit {

  
  constructor(private pricingData : PricingDataService, private newsData : NewsService) { }

  post : FinancialPricingInterface[];
  postNews : FinancialNewsInterface[];

  ngOnInit() {   
    this.pricingData.getPrices("TLT").subscribe(post => {
      this.post  = post;
    })
      
      this.newsData.getNews("TLT").subscribe(postNews => {
      this.postNews  = postNews;  
      })

    }
}