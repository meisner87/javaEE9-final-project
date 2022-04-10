import {Component} from '@angular/core';
import {FormBuilder, Validator, ValidatorFn, Validators} from "@angular/forms";
import {NewsFeedService} from "../../services/news-feed.service";

@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent{

  postForm = this.formBuilder.group({
    header: ['', Validators.required],
    content: ['', Validators.required],
    author: ['', Validators.required]
  })

  constructor(private formBuilder: FormBuilder,
              private newsService: NewsFeedService) {

  }

  createPost() {
    console.log("trying to create post....")
  }
}
