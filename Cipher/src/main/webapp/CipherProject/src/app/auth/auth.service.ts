// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class AuthService {
//   login(value: any) {
//     throw new Error("Method not implemented.");
//   }

//   constructor() { }
// }

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { User } from './user';

@Injectable()
export class AuthService {
  private loggedIn = new BehaviorSubject<boolean>(false); 

  get isLoggedIn() {
    return this.loggedIn.asObservable(); 
  }

  constructor(
    private router: Router
  ) {}

  login(user: User){
    if (user.email !== '' && user.password !== '' ) { 
      this.loggedIn.next(true);
      this.router.navigate(['/home']);
    }
  }

  Register(user: User){
      this.loggedIn.next(true);
      this.router.navigate(['/home']);
  }

  logout() {                            
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }
}