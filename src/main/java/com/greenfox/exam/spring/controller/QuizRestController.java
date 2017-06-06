package com.greenfox.exam.spring.controller;

import com.greenfox.exam.spring.model.AnswerWrapper;
import com.greenfox.exam.spring.model.QuestionWrapper;
import com.greenfox.exam.spring.service.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizRestController {

  @Autowired
  Quiz quiz;

  @GetMapping(value = "/questions")
  public QuestionWrapper getQuestions() {
    return quiz.getQuestions();
  }

  @PostMapping(value = "/answers")
  public void answers(@RequestBody AnswerWrapper answerWrapper) {

  }
}
