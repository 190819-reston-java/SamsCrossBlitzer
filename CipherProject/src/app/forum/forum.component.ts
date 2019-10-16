import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

<<<<<<< HEAD
const oUrl="";
const promise = new Promise<string>((resolve, reject) => {})

=======
const oURL = "";
>>>>>>> 40d637350cc1ac441c7cd8fa9cd606a63a3b6b70

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

  onClick() { {
    fetch(oUrl, { method: "GET" })
  }
  promise.then((response) => {
    return response.toString();
  })
  this.formSubmitAttempt = true;
}

}
