import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FinancialNewsInterface } from "./FinancialNewsInterface";


@Injectable({
  providedIn: 'root'
})
export class NewsService {

  ticker: string;
  post : FinancialNewsInterface[];

  PRICING_URL : string = 
 'https://stocknewsapi.com/api/v1?tickers=tsla&items=50&token=t7gdmzbu6t0aq4t7buq4zt8sengdwxsjcyqciyo5';
  
  constructor(private http : HttpClient) { }

  getNews(): Observable<FinancialNewsInterface[]> {
    return this.http.get<FinancialNewsInterface[]>(this.PRICING_URL);
    }
  }
