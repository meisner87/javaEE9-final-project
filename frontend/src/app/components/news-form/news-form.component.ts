import {Component} from '@angular/core';
import {FormBuilder, Validator, ValidatorFn, Validators} from "@angular/forms";
import {NewsFeedService} from "../../services/news-feed.service";
import {Post} from "../../models/post";

@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent {

  postForm = this.formBuilder.group({
    header: ['', Validators.required],
    content: ['', [Validators.required, Validators.minLength(3)]],
    author: ['', [Validators.required, Validators.minLength(3)]]
  })


  constructor(private formBuilder: FormBuilder,
              private newsService: NewsFeedService) {

  }

  onFormSubmit() {
    console.log("on submitting whole form")
    console.log(`value from form: [${JSON.stringify(this.postForm.value)}]`)


  let post: Post = {
  id:       0,
  author:   this.postForm.value.author,
  content:  this.postForm.value.content,
  header:   this.postForm.value.header,
  creationTimestamp: null,
  updateTimestamp: null
}

  this.newsService.createNewPost(post);

}
}
