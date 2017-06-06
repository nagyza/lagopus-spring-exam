package com.greenfox.exam.spring.service;

import com.greenfox.exam.spring.model.*;
import com.greenfox.exam.spring.repository.QuestionAndAnswerRepository;
import com.greenfox.exam.spring.repository.QuestionListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Quiz {

  @Autowired
  QuestionAndAnswerRepository questionAndAnswerRepository;

  @Autowired
  QuestionListRepository questionListRepository;

  public Quiz() {
  }

  public boolean analizeAnswers(AnswerWrapper answerWrapper) {
    if (!checkAnswerWrapperId(answerWrapper.getId())) {
      return false;
    } else if (answerWrapper.getAnswers().size() < 5){
      return false;
    } else if (answerWrapper.getAnswers().size() > 5) {
      return false;
    } else {
      return checkAnswers(answerWrapper);
    }
  }

  private boolean checkAnswers(AnswerWrapper answerWrapper) {
    boolean allAnswerOk = true;
    for (int i = 0; i < 5; i++) {
      Long id = answerWrapper.getAnswers().get(i).getId();
      String answer = answerWrapper.getAnswers().get(i).getAnswer();
      if (!checkAnswer(id, answer)) {
        allAnswerOk = false;
      }
    }
    return allAnswerOk;
  }

  private boolean checkAnswer(Long id, String answer) {
    if (questionAndAnswerRepository.findOne(id).getAnswer().equals(answer)) {
      return true;
    } else {
      return false;
    }
  }

  private boolean checkAnswerWrapperId(Long id) {
    if (questionListRepository.findOne(id) != null) {
      return true;
    } else {
      return false;
    }
  }

  public QuestionWrapper getQuestions() {
    QuestionWrapper questionWrapper = new QuestionWrapper();
    List<Long> questionIds = new ArrayList<>();
    while (questionIds.size() < 5){
      QuestionAndAnswer questionAndAnswer = randomQuestion();
      if (questionIds.size() == 0) {
        questionIds.add(questionAndAnswer.getId());
        questionWrapper.addQuestion(new Question(questionAndAnswer.getId(), questionAndAnswer.getQuestion()));
      } else {
        boolean hasTheSame = false;
        for (Long questionId : questionIds) {
          if (questionId == questionAndAnswer.getId()) {
            hasTheSame = true;
          }
        }
        if (!hasTheSame) {
          questionIds.add(questionAndAnswer.getId());
          questionWrapper.addQuestion(new Question(questionAndAnswer.getId(), questionAndAnswer.getQuestion()));
        } else {
          questionAndAnswer = randomQuestion();
        }
      }
    }
    QuestionWrapper questionWrapperToSave = questionWrapper;
    QuestionList questionList = new QuestionList(questionWrapper.getQuestions().get(0).getId(),
            questionWrapper.getQuestions().get(1).getId(),
            questionWrapper.getQuestions().get(2).getId(),
            questionWrapper.getQuestions().get(3).getId(),
            questionWrapper.getQuestions().get(4).getId());
    questionListRepository.save(questionList);
    questionWrapper.setId(questionList.getId());
    return questionWrapper;
  }

  private QuestionAndAnswer randomQuestion() {
    return questionAndAnswerRepository.findOne(random());
  }

  private Long random() {
    return (long) (Math.random() * questionAndAnswerRepository.count()) + 1;
  }
}
