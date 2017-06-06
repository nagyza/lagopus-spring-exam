package com.greenfox.exam.spring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionList {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Setter
  @Getter
  private Long id;
  private Long messageId1;
  private Long messageId2;
  private Long messageId3;
  private Long messageId4;
  private Long messageId5;

  public QuestionList() {
  }

  public QuestionList(Long messageId1, Long messageId2, Long messageId3, Long messageId4, Long messageId5) {
    this.messageId1 = messageId1;
    this.messageId2 = messageId2;
    this.messageId3 = messageId3;
    this.messageId4 = messageId4;
    this.messageId5 = messageId5;
  }
}
