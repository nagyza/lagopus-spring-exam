package com.greenfox.exam.spring.repository;

import com.greenfox.exam.spring.model.QuestionList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionListRepository extends CrudRepository<QuestionList, Long> {
}
