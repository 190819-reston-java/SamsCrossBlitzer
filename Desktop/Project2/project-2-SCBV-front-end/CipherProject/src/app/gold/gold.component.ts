import { Component, OnInit } from  '@angular/core';
import {PricingDataService} from '../pricing.service';
import { HttpClient } from '@angular/common/http';
import {Post} from '../Post'

@Component({
  selector: 'app-gold',
  templateUrl: './gold.component.html',
  styleUrls: ['./gold.component.css']
})
export class GoldComponent implements OnInit {

  post : Post;

  constructor(private pricingData : PricingDataService) { }

  ngOnInit() {   
    this.pricingData.getPrices().subscribe(post => {
      console.log(post); 
    }) 
    
  }

}
