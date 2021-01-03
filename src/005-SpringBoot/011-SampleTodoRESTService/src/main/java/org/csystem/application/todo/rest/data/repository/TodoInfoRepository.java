package org.csystem.application.todo.rest.data.repository;

import org.csystem.application.todo.rest.data.entity.TodoInfo;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

@Repository
public class TodoInfoRepository implements ITodoInfoRepository {
    private static final Vector<TodoInfo> ms_todoInfos = new Vector<>(); // Şu an için veritabanı olarak kullanılıyor. Aynı anda erişim dikkate alınmıyor
    private static int ms_curIndex = 1;

    @Override
    public Iterable<TodoInfo> findAll()
    {
        return ms_todoInfos;
    }

    @Override
    public boolean exitsById(Long id)
    {
        return findById(id).isPresent();
    }

    @Override
    public Optional<TodoInfo> findById(Long id)
    {
        return ms_todoInfos.stream().filter(td -> td.getId() == id).findFirst();
    }

    @Override
    public Iterable<TodoInfo> findByMonth(int month)
    {
        return ms_todoInfos.stream().filter(td -> td.getStartDate().getMonthValue() == month).collect(Collectors.toList());
    }

    @Override
    public Iterable<TodoInfo> findByMonthsBetween(int start, int end)
    {
        if (start > end)
            throw new IllegalArgumentException("Illegal Arguments");

        return ms_todoInfos.stream()
                .filter(td -> start <= td.getStartDate().getMonthValue() && td.getStartDate().getMonthValue() < end)
                .collect(Collectors.toList());
    }

    @Override
    public <S extends TodoInfo> S save(S entity)
    {
        entity.setId(ms_curIndex++);
        ms_todoInfos.add(entity);

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
