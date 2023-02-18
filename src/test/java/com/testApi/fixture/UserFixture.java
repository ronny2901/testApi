package com.testApi.fixture;

import java.time.LocalDateTime;
import java.util.Locale;

import com.github.javafaker.Faker;
import com.testApi.persistence.entity.UsersEntity;

public final class UserFixture {

    private static final Faker FAKER = new Faker(new Locale("pt", "BR"));

    public static UsersEntity createRandomUser() {
        return UsersEntity.builder()
                .id(FAKER.random().nextLong())
                .login(FAKER.name().username())
                .name(FAKER.funnyName().name())
                .nodeId(FAKER.name().username())
                .avatarUrl(FAKER.internet().url())
                .gravatarId(FAKER.name().username())
                .url(FAKER.internet().url())
                .htmlUrl(FAKER.internet().url())
                .followersUrl(FAKER.internet().url())
                .followingUrl(FAKER.internet().url())
                .gistsUrl(FAKER.internet().url())
                .starredUrl(FAKER.internet().url())
                .subscriptionsUrl(FAKER.internet().url())
                .organizationsUrl(FAKER.internet().url())
                .reposUrl(FAKER.internet().url())
                .eventsUrl(FAKER.internet().url())
                .receivedEventsUrl(FAKER.internet().url())
                .type(FAKER.animal().name())
                .siteAdmin(FAKER.bool().bool())
                .company(FAKER.company().name())
                .blog(FAKER.internet().url())
                .location(FAKER.address().country())
                .email(FAKER.lordOfTheRings().location())
                .hireable(FAKER.lordOfTheRings().character())
                .bio(FAKER.ancient().hero())
                .twitterUsername(FAKER.name().username())
                .publicRepos(FAKER.number().randomDigitNotZero())
                .publicGists(FAKER.number().randomDigitNotZero())
                .followers(FAKER.number().randomDigitNotZero())
                .following(FAKER.number().randomDigitNotZero())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
