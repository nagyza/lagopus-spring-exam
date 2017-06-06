package com.greenfox.exam.spring.service;

import com.greenfox.exam.spring.model.Question;
import com.greenfox.exam.spring.model.QuestionWrapper;
import com.greenfox.exam.spring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Quiz {

  @Autowired
  QuestionRepository questionRepository;

  public Quiz() {
  }

  public QuestionWrapper getQuestions() {
    QuestionWrapper questionWrapper = new QuestionWrapper();
    for (int i = 0; i < 5; i++) {
      questionWrapper.addQuestion(randomQuestion());
    }
    return questionWrapper;
  }

  private Question randomQuestion() {
    return questionRepository.findOne(random());
  }

  private long random() {
    return (long) (Math.random() * questionRepository.count()) + 1;
  }
}
