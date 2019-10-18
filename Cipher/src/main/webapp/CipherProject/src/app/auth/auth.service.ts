import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { User } from './user';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClientModule, HttpBackend } from '@angular/common/http';
import { Response } from 'selenium-webdriver/http';

const baseUrl= "http://localhost:8080/Cipher";
const oUrl= `${baseUrl}/userlogin`;

@Injectable()
export class AuthService {
  private loggedIn = new BehaviorSubject<boolean>(false); 
  form: FormGroup;

  get isLoggedIn() {
    return this.loggedIn.asObservable(); 
  }

  constructor(
    private router: Router
  ) {}

  login(user: User){
    console.log(user);
    if (user.useremail !== '' && user.userpassword !== '' ) {
      this.loggedIn.next(true);
      this.router.navigate(['/home']);
    }
  }

  Register(user: User){
    console.log(user);
      this.loggedIn.next(true);
      this.router.navigate(['/home']);
  }

  logout() {                            
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }
}