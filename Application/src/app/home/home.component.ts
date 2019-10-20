import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { AuthService } from './../auth/auth.service';
import { PortfolioInterface } from '../PortfolioInterface';
import { PortfolioConstruction } from '../portfolio.service';
import { GeneralNewsInterface } from '../GeneralNewsInterface';
import { GeneralNewsService } from '../general-news-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private portfoliosData : PortfolioConstruction,
              private newsData : GeneralNewsService,
              private authService: AuthService) { }

  
  isLoggedIn$: Observable<boolean>;  
  ticker : string;
  post : PortfolioInterface[];
  postNews : GeneralNewsInterface[];

  ngOnInit() {
    this.isLoggedIn$ = this.authService.isLoggedIn;
    this.portfoliosData.getPortfolios("SPY", ["TLT","USO","GLD",
    "UUP","UNG","EUR.FOREX","FXI","GBTC","SLV","GOOG","AAPL",
    "F","YUM","Z","P","FB"]).subscribe(post => {
    this.post  = post;
    })

    this.newsData.getNews().subscribe(postNews => {
      this.postNews  = postNews;  })

  }

}