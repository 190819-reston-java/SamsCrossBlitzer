import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PortfolioInterface } from './PortfolioInterface';

@Injectable({
  providedIn: 'root'
})
export class PortfolioConstruction {

  ticker: string;
  tickers : string[];
  post : PortfolioInterface[];

  PRICING_URL : string ;
  
  constructor(private http : HttpClient) { }

  getPortfolios(ticker,tickers): Observable<PortfolioInterface[]> {
    
    this.PRICING_URL  = 
    'https://eodhistoricaldata.com/api/real-time/' + ticker 
    + '.US?api_token=5d9f47f01c65d7.74116296&fmt=json&s=' + tickers;
    

      return this.http.get<PortfolioInterface[]>(this.PRICING_URL);
    }
  }