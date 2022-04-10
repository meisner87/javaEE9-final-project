import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validator, ValidatorFn, Validators} from "@angular/forms";

@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent implements OnInit {

  postForm = this.formBuilder.group({
    header: ['', Validators.required],
    content: ['', Validators.required],
    author: ['', Validators.required]
  })

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
  }

  createPost() {
    console.log("trying to create post....")
  }
}
