package com.testApi.service;

import com.testApi.api.error.PersistenceException;
import com.testApi.persistence.repository.UserRepository;
import com.testApi.service.integrations.UserComponent;
import com.testApi.persistence.entity.UsersEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class UserService {
    final UserRepository repository;
    final UserComponent userComponent;
    final ModelMapper modelMapper;

    public UsersEntity findUserProfile(final String login) {
        UsersEntity userEntity = getProfileFromDatabase(login);
        if (Objects.nonNull(userEntity)) {
            return userEntity;
        } else {
            var userDto = userComponent.getProfileFromGithub(login);
            return saveProfile(modelMapper.map(userDto, UsersEntity.class));
        }
    }

    private UsersEntity getProfileFromDatabase(String login) {
        try {
            var entity = repository.findByLogin(login);
            log.info("stage=get-by-name-success, profile={}", entity);
            return entity;
        } catch (DataIntegrityViolationException exception) {
            String msgError = exception.getCause().getCause().getMessage();
            log.error("stage=save-type-attachment-error, type-attachment={}, msg={}",
                    login, msgError);
            throw new PersistenceException(msgError);
        }
    }

    @Async
    public UsersEntity saveProfile(UsersEntity userEntity) {
        try {
            var entity = repository.save(userEntity);
            log.info("stage=save-success, profile={}", entity);
            return entity;
        } catch (DataIntegrityViolationException exception) {
            String msgError =  exception.getMessage();
            log.error("stage=save-error, type-attachment={}, msg={}",
                    userEntity, msgError);
            throw new PersistenceException( msgError);
        }
    }
}
