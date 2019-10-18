import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AuthService } from './../auth/auth.service';

const oUrl="";
const promise = new Promise<string>((resolve, reject) => {})


@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
  form: FormGroup;
  private formSubmitAttempt: boolean;

  isLoggedIn$: Observable<boolean>;  

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.form = this.fb.group({
      forumstopic: [''],
      forumscomment: ['']
    });
    this.isLoggedIn$ = this.authService.isLoggedIn;
  }

  onSubmit() { {
      fetch(oUrl, { method: "POST", body: JSON.stringify(this.form.value)})
    }
    this.formSubmitAttempt = true;
  }

  onClick() { {
    fetch(oUrl, { method: "GET" })
  }
  promise.then((response) => {
    return response.toString();
  })
  this.formSubmitAttempt = true;
}

}
