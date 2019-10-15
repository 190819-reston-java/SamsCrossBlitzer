import { Component, OnInit } from  '@angular/core';
import { FinancialNewsInterface } from "../FinancialNewsInterface";
import { NewsService } from '../news.service';

@Component({
  selector: 'app-stocks',
  templateUrl: './stocks.component.html',
  styleUrls: ['./stocks.component.css']
})
export class StocksComponent implements OnInit {

  post : FinancialNewsInterface[];

  constructor(private newsData : NewsService) { }

  
  ngOnInit() {   
    this.newsData.getNews().subscribe(post => {
      this.post  = post;
    }) 

  }
}
