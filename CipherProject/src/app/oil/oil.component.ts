import { Component, OnInit } from  '@angular/core';
import {PricingDataService} from '../pricing.service';
import {FinancialPricingInterface} from '../FinancialPricingInterface'

@Component({
  selector: 'app-oil',
  templateUrl: './oil.component.html',
  styleUrls: ['./oil.component.css']
})
export class OilComponent implements OnInit {

  constructor(private pricingData : PricingDataService) { }

  post : FinancialPricingInterface[];

  ngOnInit() {   
    this.pricingData.getPrices().subscribe(post => {
      this.post  = post;
   
    }) 

  }
}