package com.greenfox.exam.spring.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Component
@Getter
@Setter
public class QuestionWrapper {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private List<Question> questions;

  public QuestionWrapper() {
  }

  public void addQuestion(Question question) {
    this.questions.add(question);
  }
}
