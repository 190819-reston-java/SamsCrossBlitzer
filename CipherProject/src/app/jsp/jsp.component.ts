import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { AuthService } from './../auth/auth.service';

@Component({
  selector: 'app-jsp',
  templateUrl: './jsp.component.html',
  styleUrls: ['./jsp.component.css']
})
export class JSPComponent implements OnInit {

  isLoggedIn$: Observable<boolean>; 

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.isLoggedIn$ = this.authService.isLoggedIn;
  }

}
