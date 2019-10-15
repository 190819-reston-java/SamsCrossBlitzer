import { Component, OnInit } from  '@angular/core';
import {PricingDataService} from '../pricing.service';
import { HttpClient } from '@angular/common/http';
import {FinancialPricingInterface} from '../FinancialPricingInterface'

@Component({
  selector: 'app-gold',
  templateUrl: './gold.component.html',
  styleUrls: ['./gold.component.css']
})
export class GoldComponent implements OnInit {

  post : FinancialPricingInterface[];

  constructor(private pricingData : PricingDataService) { }

  
  ngOnInit() {   
    this.pricingData.getPrices().subscribe(post => {
      this.post  = post;
    }) 

  }
}

