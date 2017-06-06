package com.greenfox.exam.spring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {

  private Long id;
  private String question;

  public Question() {
  }

  public Question(Long id, String question) {
    this.id = id;
    this.question = question;
  }
}
