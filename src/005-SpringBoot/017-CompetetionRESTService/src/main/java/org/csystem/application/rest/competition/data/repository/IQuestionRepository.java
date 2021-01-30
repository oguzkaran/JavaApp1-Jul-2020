package org.csystem.application.rest.competition.data.repository;

import org.csystem.application.rest.competition.data.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface IQuestionRepository extends CrudRepository<Question, Long> {
}
