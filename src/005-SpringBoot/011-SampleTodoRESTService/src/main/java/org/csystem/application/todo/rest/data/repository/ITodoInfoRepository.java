package org.csystem.application.todo.rest.data.repository;

import org.csystem.application.todo.rest.data.entity.TodoInfo;
import org.csystem.util.data.repository.ICrudRepository;

public interface ITodoInfoRepository extends ICrudRepository<TodoInfo, Long> {
    Iterable<TodoInfo> findByMonth(int month);
}
