package com.greenfox.exam.spring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {

  private Long id;
  private String answer;

  public Answer() {
  }

  public Answer(Long id, String answer) {
    this.id = id;
    this.answer = answer;
  }
}
