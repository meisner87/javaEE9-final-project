package com.javaee9.javaee9finalproject.controller;

import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/posts")
//never - ever use entities inside controllers(use dtos)
@CrossOrigin("http://localhost:4200")

public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //readRecentPosts - NEWER EVER !!!
    // /posts?boundary = vs /posts/recent
    @GetMapping("/recent")
    public List<PostDto> readRecentPosts() {
        log.info("reading recent posts");

        return postService.readRecentPosts();
    }

    @GetMapping("/recent/{id}")
    public PostDto findRecentPostById(@PathVariable("id") Long postId) {
        // TODO: finish implementation
        // read Post by id from database
        // convert Post into PostDto
        // return to user
        return new PostDto(1L,
                "myPost",
                "content",
                "me",
                "1998",
                "1988");
    }

    @PostMapping()
    public PostDto createNewPost(@Valid @RequestBody PostDto toStore) {
        log.info("trying to store new post: [{}]", toStore);
        return postService.createNewPost(toStore);
    }


}
