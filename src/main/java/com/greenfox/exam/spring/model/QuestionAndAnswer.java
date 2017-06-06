package com.greenfox.exam.spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class QuestionAndAnswer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String question;
  private String answer;

  public QuestionAndAnswer() {
  }
}