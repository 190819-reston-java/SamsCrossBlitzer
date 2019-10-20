import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {

  constructor(private router: Router,private http : HttpClient) { }

  postsUrl: string = 'http://localhost:8080/Cipher/logout';

  ngOnInit() {
    this.http.get(this.postsUrl);
    this.router.navigate(['/home']);  
  }

}
