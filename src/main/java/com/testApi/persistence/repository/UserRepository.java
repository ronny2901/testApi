package com.testApi.persistence.repository;

import com.testApi.persistence.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

    UsersEntity findByLogin(String login);

}
