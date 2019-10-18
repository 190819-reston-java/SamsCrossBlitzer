import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/auth.service';

const oURL = "";

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
  form: FormGroup;
  private formSubmitAttempt: boolean;
  isLoggedIn$: Observable<boolean>; 

  constructor(private fb: FormBuilder, private http: HttpClient,private authService: AuthService) {}

  ngOnInit() {
    this.isLoggedIn$ = this.authService.isLoggedIn;
    this.form = this.fb.group({
      forumstopic: [''],
      forumscomment: ['']
    });
  }

  onSubmit() { {
      fetch(oURL, { method: "POST", body: JSON.stringify(this.form.value)})
    }
    this.formSubmitAttempt = true;
  }

}
