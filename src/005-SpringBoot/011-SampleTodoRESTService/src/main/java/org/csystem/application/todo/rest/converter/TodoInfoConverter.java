package org.csystem.application.todo.rest.converter;

import org.csystem.application.todo.rest.data.entity.TodoInfo;
import org.csystem.application.todo.rest.dto.TodoInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoInfoConverter {
    public TodoInfoDTO todoInfoToTodoInfoDTO(TodoInfo todoInfo)
    {
        var todoInfoDTO = new TodoInfoDTO();

        todoInfoDTO.setId(todoInfo.getId());
        todoInfoDTO.setUsername(todoInfo.getUsername());
        todoInfoDTO.setTitle(todoInfo.getTitle());
        todoInfoDTO.setDescription(todoInfo.getDescription());
        todoInfoDTO.setStartDate(todoInfo.getStartDate());
        todoInfoDTO.setExpectedEndDate(todoInfo.getExpectedEndDate());
        todoInfoDTO.setEndDate(todoInfo.getEndDate());
        todoInfoDTO.setCompleted(todoInfo.isCompleted());

        return todoInfoDTO;
    }

    public TodoInfo todoInfoDTOToTodoInfo(TodoInfoDTO todoInfoDTO)
    {
        var todoInfo = new TodoInfo();

        todoInfo.setId(todoInfoDTO.getId());
        todoInfo.setUsername(todoInfoDTO.getUsername());
        todoInfo.setTitle(todoInfoDTO.getTitle());
        todoInfo.setDescription(todoInfoDTO.getDescription());
        todoInfo.setStartDate(todoInfoDTO.getStartDate());
        todoInfo.setExpectedEndDate(todoInfoDTO.getExpectedEndDate());
        todoInfo.setCompleted(todoInfoDTO.isCompleted());

        return todoInfo;
    }
}
