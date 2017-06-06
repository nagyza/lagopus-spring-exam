package com.greenfox.exam.spring.service;

import com.greenfox.exam.spring.model.Question;
import com.greenfox.exam.spring.model.QuestionAndAnswer;
import com.greenfox.exam.spring.model.QuestionWrapper;
import com.greenfox.exam.spring.repository.QuestionAndAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Quiz {

  @Autowired
  QuestionAndAnswerRepository questionAndAnswerRepository;

  public Quiz() {
  }

  public QuestionWrapper getQuestions() {
    QuestionWrapper questionWrapper = new QuestionWrapper();
    QuestionAndAnswer questionAndAnswer = randomQuestion();
    for (int i = 0; i < 5; i++) {
      questionWrapper.addQuestion(new Question(questionAndAnswer.getId(), questionAndAnswer.getQuestion()));
    }
    return questionWrapper;
  }

  private QuestionAndAnswer randomQuestion() {
    return questionAndAnswerRepository.findOne(random());
  }

  private long random() {
    return (long) (Math.random() * questionAndAnswerRepository.count()) + 1;
  }
}
