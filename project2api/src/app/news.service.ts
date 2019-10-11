import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FinancialNewsService, DataEntity } from './FinancialNewsInterface';


@Injectable({
  providedIn: 'root'
})
export class NewsService {

  ticker: string;
  post :FinancialNewsService[];

  PRICING_URL : string = 
 'https://stocknewsapi.com/api/v1?tickers=c&items=50&token=t7gdmzbu6t0aq4t7buq4zt8sengdwxsjcyqciyo5';
  
  constructor(private http : HttpClient) { }

  getNews(): Observable<FinancialNewsService[]> {
    return this.http.get<FinancialNewsService[]>(this.PRICING_URL);
    }
  }
