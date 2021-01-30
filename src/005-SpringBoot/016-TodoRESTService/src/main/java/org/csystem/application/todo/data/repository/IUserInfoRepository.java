package org.csystem.application.todo.data.repository;

import org.csystem.application.todo.data.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserInfoRepository extends CrudRepository<UserInfo, String> {
    Optional<UserInfo> findByUsername(String username);
}
