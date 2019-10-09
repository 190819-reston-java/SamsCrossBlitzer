import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PricingDataService {

  ticker: string;

  PRICING_URL : string = 
  'https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&apikey=OROO7ASK2TML6DSR';

  constructor(private http : HttpClient) { }

  getPrices(): any {
    return this.http.get(this.PRICING_URL);
  }
}
