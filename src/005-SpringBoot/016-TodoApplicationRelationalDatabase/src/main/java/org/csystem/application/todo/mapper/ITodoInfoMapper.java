package org.csystem.application.todo.mapper;

import org.csystem.application.todo.data.entity.TodoInfo;
import org.csystem.application.todo.dto.TodoInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TodoInfoMapperImpl", componentModel = "spring")
public interface ITodoInfoMapper {
    TodoInfoDTO todoInfoToTodoInfoDTO(TodoInfo todoInfo);
    TodoInfo todoInfoDTOToTodoInfo(TodoInfoDTO todoInfoDTO);
}
