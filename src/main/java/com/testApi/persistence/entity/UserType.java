package com.testApi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public enum UserType {

    USER, ADMIN;

    @JsonCreator
    public static UserType fromString(String value){
        return List.of(UserType.values()).stream()
                .filter(type -> type.name().equalsIgnoreCase(value))
                .findAny()
                .orElse(null);
    }
}
