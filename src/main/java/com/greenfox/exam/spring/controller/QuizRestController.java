package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.QuestionWrapper;
import com.greenfox.exam.spring.service.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizRestController {

  @Autowired
  Quiz quiz;

  @GetMapping(value = "/questions")
  public QuestionWrapper getQuestions() {
    return quiz.getQuestions();
  }
}
