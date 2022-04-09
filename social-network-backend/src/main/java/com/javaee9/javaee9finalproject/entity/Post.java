package com.javaee9.javaee9finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Clock;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String header;
    @NotEmpty
    @Size(min = 3, message = "you're post is to short :)")
    String content;
    @Size(min = 3, message = "you're post is to short :)")
    @NotEmpty
    String author;
    ZonedDateTime creationTimestamp;
    ZonedDateTime updateTimestamp;

    @PrePersist
    private void setInitialTimestamp() {
        ZonedDateTime timestamp = ZonedDateTime.now(Clock.systemUTC());
        creationTimestamp = timestamp;
        updateTimestamp = creationTimestamp;

    }

    @PreUpdate
    private void setUpdateTimestamp() {
        updateTimestamp = ZonedDateTime.now(Clock.systemUTC());

    }
}
