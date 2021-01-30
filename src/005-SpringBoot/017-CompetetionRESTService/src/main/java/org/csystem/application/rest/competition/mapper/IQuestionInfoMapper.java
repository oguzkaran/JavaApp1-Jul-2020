package org.csystem.application.rest.competition.mapper;

import org.csystem.application.rest.competition.data.entity.Question;
import org.csystem.application.rest.competition.dto.QuestionInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "QuestionInfoMapperImpl", componentModel = "spring")
public interface IQuestionInfoMapper {
    @Mappings({
            @Mapping(source = "question.description", target = "description"),
            @Mapping(source = "question.answerIndex", target = "answerIndex"),
            @Mapping(source = "question.options", target = "options"),
            @Mapping(source = "question.level.description", target = "levelStr")
    })
    QuestionInfoDTO toQuestionInfoDTO(Question question);
    Question toQuestion(QuestionInfoDTO questionInfoDTO);
}
