package com.javaee9.javaee9finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    String content;
    String author;
    ZonedDateTime creationTimestamp;
    ZonedDateTime updateTimestamp;

    @PrePersist
    private void setInitialTimestamp() {
        ZonedDateTime timestamp = ZonedDateTime.now(Clock.systemUTC());
        creationTimestamp = timestamp;
        updateTimestamp = updateTimestamp;

    }

    @PreUpdate
    private void setUpdateTimestamp() {
        updateTimestamp = ZonedDateTime.now(Clock.systemUTC());

    }
}
