package com.testApi.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@Entity(name="Users")
@FieldDefaults(level= AccessLevel.PRIVATE)
public class UsersEntity {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "login")
    String login;
    @Column(name = "node_id")
    String nodeId;
    @Column(name = "avatar_url")
    String avatarUrl;
    @Column(name = "gravatar_id")
    String gravatarId;
    @Column(name = "url")
    String url;
    @Column(name = "html_url")
    String htmlUrl;
    @Column(name = "followers_url")
    String followersUrl;
    @Column(name = "following_url")
    String followingUrl;
    @Column(name = "gists_url")
    String gistsUrl;
    @Column(name = "starred_url")
    String starredUrl;
    @Column(name = "subscriptions_url")
    String subscriptionsUrl;
    @Column(name = "organizations_url")
    String organizationsUrl;
    @Column(name = "repos_url")
    String reposUrl;
    @Column(name = "events_url")
    String eventsUrl;
    @Column(name = "received_events_url")
    String receivedEventsUrl;
    @Column(name = "type")
    String type;
    @Column(name = "site_admin")
    boolean siteAdmin;
    @Column(name = "company")
    String company;
    @Column(name = "blog")
    String blog;
    @Column(name = "location")
    String location;
    @Column(name = "email")
    String email;
    @Column(name = "hireable")
    String hireable;
    @Column(name = "bio")
    String bio;
    @Column(name = "twitter_username")
    String twitterUsername;
    @Column(name = "public_repos")
    int publicRepos;
    @Column(name = "public_gists")
    int publicGists;
    @Column(name = "followers")
    int followers;
    @Column(name = "following")
    int following;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
