import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, } from '@angular/forms';
import { AuthService } from './../auth/auth.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

const oUrl = "";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form: FormGroup;
  private formSubmitAttempt: boolean;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private http: HttpClient,
    private router: Router
  ) { }

  ngOnInit() {
    this.form = this.fb.group({
      firstname: [''],
      lastname: [''],
      email: [''],
      password: ['']
    });
  }

  onSubmit() {
    {
      if (this.form.valid) {
        fetch(oUrl, { method: "POST", body: JSON.stringify(this.form.value) })
        this.authService.Register(this.form.value);
      this.formSubmitAttempt = true;
    } else {
      alert("Please enter valid inputs in each field.")
    }
    }
  }
}