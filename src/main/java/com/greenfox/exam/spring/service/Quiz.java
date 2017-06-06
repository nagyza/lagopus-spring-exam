package com.greenfox.exam.spring.service;

import com.greenfox.exam.spring.model.Question;
import com.greenfox.exam.spring.model.QuestionAndAnswer;
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
      questionWrapper.addQuestion(new Question(randomQuestion().getId(), randomQuestion().getQuestion()));
    }
    return questionWrapper;
  }

  private QuestionAndAnswer randomQuestion() {
    return questionRepository.findOne(random());
  }

  private long random() {
    return (long) (Math.random() * questionRepository.count()) + 1;
  }
}
