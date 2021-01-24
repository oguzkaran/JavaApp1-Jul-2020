package org.csystem.application.todo.data.repository;

import org.csystem.application.todo.data.entity.TodoInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITodoInfoRepository extends CrudRepository<TodoInfo, Long> {
    @Query(value = "select * from todos where date_part('month', start_date)=?", nativeQuery = true)
    Iterable<TodoInfo> findByMonth(int month);

    @Query(value = "select * from todos where date_part('month', start_date) between ? and ?", nativeQuery = true)
    Iterable<TodoInfo> findByMonthsBetween(int start, int end);

    @Query("from TodoInfo ti where ti.completed=true") //HQL, JQL
    Iterable<TodoInfo> findCompleted();

    @Query("from TodoInfo ti where ti.completed=false") //HQL, JQL
    Iterable<TodoInfo> findNotCompleted();

    Iterable<TodoInfo> findByCompleted(boolean completed);

    @Query(value="select * from todos order by start_date limit ?", nativeQuery = true)
    Iterable<TodoInfo> findByCount(int count);
}
