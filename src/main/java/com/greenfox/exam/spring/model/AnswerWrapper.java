package com.greenfox.exam.spring.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class AnswerWrapper {

  private Long id;
  private List<Question> answers;

  public AnswerWrapper() {
    this.answers = new ArrayList<>();
  }
}
