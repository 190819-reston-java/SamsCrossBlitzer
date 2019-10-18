import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from './../auth/auth.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

const baseUrl= "http://localhost:8080/Cipher";
const oUrl= `${baseUrl}/userlogin`;
const o2Url="http://localhost:4200";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  private formSubmitAttempt: boolean;
  private loggedIn = new BehaviorSubject<boolean>(false); 


  constructor(
    private fb: FormBuilder,    
    private authService: AuthService,
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit() {
    this.form = this.fb.group({  
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  isFieldInvalid(field: string) { 
    return (
      (!this.form.get(field).valid && this.form.get(field).touched) ||
      (this.form.get(field).untouched && this.formSubmitAttempt)
    );
  }

  onSubmit() {
    if (this.form.valid) {
    fetch(oUrl, { method: "POST", body: JSON.stringify(this.form.value)})
    .then((response)=>{
      console.log(response);
      console.log(response.status);
      if(response.status == 200) {
        this.authService.login(this.form.value);
      }
      return response.json();
    }).catch(console.log);
    // fetch(o2Url, { method: "GET" }).then((response)=> {
    //   return response.json();
    // })
    // console.log(this.checkResponse());

      console.log(this.form.value);
    }
    this.formSubmitAttempt = true;
  }

  // checkResponse() {
  //   this.http.get(o2Url, { observe: 'response' })
  //   .subscribe(response => console.log(response.status));
  // }

  // onSubmit() {
  //   this.loggedIn.next(true);
  //   this.router.navigate(['/home']);
  //   // this.authService.login(this.form);
  // }

  Register() {
    this.router.navigate(['/register']);
  }
}