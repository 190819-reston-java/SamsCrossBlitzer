import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FinancialNewsInterface} from './FinancialNewsInterface';
import { GeneralNewsInterface } from './GeneralNewsInterface';


@Injectable({
  providedIn: 'root'
})
export class GeneralNewsService {

  ticker: string;
  post : GeneralNewsInterface[];

  PRICING_URL : string ; 
  
  constructor(private http : HttpClient) { }

  getNews(): Observable<GeneralNewsInterface[]> {
    this.PRICING_URL  = 
    'https://stocknewsapi.com/api/v1/category?section=general&items=19&token'
    + '=t7gdmzbu6t0aq4t7buq4zt8sengdwxsjcyqciyo5';
    return this.http.get<GeneralNewsInterface[]>(this.PRICING_URL);
    }
  }
