package org.csystem.application.todo.rest.converter;

import org.csystem.application.todo.rest.data.entity.TodoInfo;
import org.csystem.application.todo.rest.dto.TodoInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoInfoConverter {
    public TodoInfoDTO todoInfoToTodoInfoDTO(TodoInfo todoInfo)
    {
        return new TodoInfoDTO();
    }

    public TodoInfo todoInfoDTOToTodoInfo(TodoInfoDTO todoInfo)
    {
        return new TodoInfo();
    }
}
