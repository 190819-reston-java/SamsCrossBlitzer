import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

const oURL = "";

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
  form: FormGroup;
  private formSubmitAttempt: boolean;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient
  ) {}

  ngOnInit() {
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
