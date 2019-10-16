import { Component, OnInit } from  '@angular/core';
import {PricingDataService} from '../pricing.service';
import {FinancialPricingInterface} from '../FinancialPricingInterface'
import { FinancialNewsInterface } from '../FinancialNewsInterface';
import { NewsService } from '../news.service';

@Component({
  selector: 'app-oil',
  templateUrl: './oil.component.html',
  styleUrls: ['./oil.component.css']
})
export class OilComponent implements OnInit {

  constructor(private pricingData : PricingDataService, private newsData : NewsService) { }

  post : FinancialPricingInterface[];
  postNews : FinancialNewsInterface[];

  ngOnInit() {   
    this.pricingData.getPrices("USO").subscribe(post => {
      this.post  = post;
    })
      
      this.newsData.getNews("USO").subscribe(postNews => {
      this.postNews  = postNews;  
      })

    }
}