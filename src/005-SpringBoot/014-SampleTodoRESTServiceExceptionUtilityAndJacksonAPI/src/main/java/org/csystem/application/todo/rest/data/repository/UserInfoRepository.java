package org.csystem.application.todo.rest.data.repository;

import org.csystem.application.todo.rest.data.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserInfoRepository implements IUserInfoRepository {
    @Override
    public long count()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(UserInfo entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends UserInfo> entities)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean exitsById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<UserInfo> findAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<UserInfo> findAllById(Iterable<Long> longs)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<UserInfo> findById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends UserInfo> S save(S entity)
    {
        return null;
    }

    @Override
    public <S extends UserInfo> Iterable<S> save(Iterable<S> entities)
    {
        return null;
    }
}
