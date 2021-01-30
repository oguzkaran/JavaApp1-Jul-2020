package org.csystem.application.todo.mapper;

import org.csystem.application.todo.data.entity.TodoInfo;
import org.csystem.application.todo.dto.TodoInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "TodoInfoMapperImpl", componentModel = "spring")
public interface ITodoInfoMapper {
    TodoInfoDTO todoInfoToTodoInfoDTO(TodoInfo todoInfo);
    TodoInfo todoInfoDTOToTodoInfo(TodoInfoDTO todoInfoDTO);
}
