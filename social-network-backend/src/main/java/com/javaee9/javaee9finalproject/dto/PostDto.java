package com.javaee9.javaee9finalproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public record PostDto(Long id,
                      String header,
                      @NotEmpty
                      @Size(min = 3, message = "you're post is to short :)")
                      String content,
                      @Size(min = 3, message = "Author name is to short")
                      @NotEmpty
                      String author,
                      @JsonProperty("creation_Timestamp")
                      String creationTimestamp,
                      @JsonProperty("update_timestamp")
                      String updateTimestamp) {
}
