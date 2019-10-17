import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from './../auth/auth.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

const baseUrl= "http://localhost:8080/Cipher";
const oUrl= `${baseUrl}/userlogin`;


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  private formSubmitAttempt: boolean;

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
    fetch(oUrl, { mode: "no-cors", method: "POST", body: JSON.stringify(this.form.value)});
      this.authService.login(this.form.value);
      console.log(this.form.value);
    }
    this.formSubmitAttempt = true;
  }

  Register() {
    this.router.navigate(['/register']);
  }
}