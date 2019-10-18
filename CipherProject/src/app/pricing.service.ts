import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {FinancialPricingInterface} from './FinancialPricingInterface'

@Injectable({
  providedIn: 'root'
})
export class PricingDataService {

  ticker: string;
  post : FinancialPricingInterface[];

  PRICING_URL : string ;
  
  constructor(private http : HttpClient) { }

  getPrices(ticker): Observable<FinancialPricingInterface[]> {
    
    this.PRICING_URL  = 
    'https://eodhistoricaldata.com/api/eod/' + ticker + 
    '.US?from=2015-01-05&to=2017-02-10&api_token=5d9f47f01c65d7.74116296&period=d&fmt=json';
      return this.http.get<FinancialPricingInterface[]>(this.PRICING_URL);
    }
  }
