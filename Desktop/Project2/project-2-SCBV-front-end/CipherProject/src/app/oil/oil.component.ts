import { Component, OnInit } from  '@angular/core';
import {PricingDataService} from '../pricing.service';
import {Post} from '../Post'

@Component({
  selector: 'app-oil',
  templateUrl: './oil.component.html',
  styleUrls: ['./oil.component.css']
})
export class OilComponent implements OnInit {

  constructor(private pricingData : PricingDataService) { }

  ngOnInit() {   
    this.pricingData.getPrices().subscribe(post => {
      console.log(post); 
    }) 

  }
}
