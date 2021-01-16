package org.csystem.application.todo.rest.data.repository;

import org.csystem.application.todo.rest.data.entity.TodoInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class TodoInfoRepository implements ITodoInfoRepository {
    private static final String FIND_ALL_SQL = "select * from todos";
    private static final String FIND_BY_ID_SQL = "select * from todos where todo_id=:todo_id";
    private static final String FIND_BY_MONTH_SQL = "select * from todos where date_part('month', start_date)=:month";
    private static final String FIND_BY_MONTHS_BETWEEN_SQL = "select * from todos where date_part('month', start_date) between :start and :end";
    private static final String SAVE_SQL = "insert into  todos (username, title, description, insert_date, start_date, expected_end_date, completed)\n" +
            "values (:username, :title, :description, :insertDate, :startDate, :expectedEndDate, :completed)";


    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    public TodoInfoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static void fillTodos(ResultSet resultSet, ArrayList<TodoInfo> todos) throws SQLException
    {
        do {
            var id = resultSet.getLong(1); //resultSet.getInt("todo_id");
            var username = resultSet.getString(2);
            var title = resultSet.getString(3);
            var description = resultSet.getString(4);
            var insertDate = resultSet.getDate(5).toLocalDate();
            var startDate = resultSet.getDate(6).toLocalDate();
            var expectedEndDate = resultSet.getDate(7).toLocalDate();
            var endDate = resultSet.getDate(8);
            var completed = resultSet.getBoolean(9);
            todos.add(new TodoInfo(id, title, username, description, startDate, insertDate, expectedEndDate, endDate == null ? null : endDate.toLocalDate(), completed));
        } while (resultSet.next());
    }

    @Override
    public Iterable<TodoInfo> findAll()
    {
        var todos = new ArrayList<TodoInfo>();

        m_namedParameterJdbcTemplate.query(FIND_ALL_SQL, (ResultSet rs) -> fillTodos(rs, todos));

        return todos;
    }

    @Override
    public boolean exitsById(Long id)
    {
        return findById(id).isPresent();
    }

    @Override
    public Optional<TodoInfo> findById(Long id)
    {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("todo_id", id);
        var todos = new ArrayList<TodoInfo>();

        m_namedParameterJdbcTemplate.query(FIND_BY_ID_SQL, parameterMap, (ResultSet rs) -> fillTodos(rs, todos));

        return todos.stream().findFirst();
    }

    @Override
    public Iterable<TodoInfo> findByMonth(int month)
    {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("month", month);
        var todos = new ArrayList<TodoInfo>();

        m_namedParameterJdbcTemplate.query(FIND_BY_MONTH_SQL, parameterMap, (ResultSet rs) -> fillTodos(rs, todos));

        return todos;
    }

    @Override
    public Iterable<TodoInfo> findByMonthsBetween(int start, int end)
    {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("start", start);
        parameterMap.put("end", end);

        var todos = new ArrayList<TodoInfo>();

        m_namedParameterJdbcTemplate.query(FIND_BY_MONTHS_BETWEEN_SQL, parameterMap, (ResultSet rs) -> fillTodos(rs, todos));

        return todos;
    }

    @Override
    public <S extends TodoInfo> S save(S entity)
    {
        var keyHolder = new GeneratedKeyHolder();

        m_namedParameterJdbcTemplate.update(SAVE_SQL, new BeanPropertySqlParameterSource(entity), keyHolder, new String[] {"todo_id"});

        entity.setId(keyHolder.getKey().intValue());

        return entity;
    }

    @Override
    public long count()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(TodoInfo entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends TodoInfo> entities)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public Iterable<TodoInfo> findAllById(Iterable<Long> longs)
    {
        throw new UnsupportedOperationException();
    }





    @Override
    public <S extends TodoInfo> Iterable<S> save(Iterable<S> entities)
    {
        return null;
    }
}
