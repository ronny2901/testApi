package com.testApi.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class UserDTO {

    @JsonProperty(value="id")
    Long id;
    @JsonProperty(value="login")
    String login;
    @JsonProperty(value="node_id")
    String nodeId;
    @JsonProperty(value="avatar_url")
    String avatarUrl;
    @JsonProperty(value="gravatar_id")
    String gravatarId;
    @JsonProperty(value="url")
    String url;
    @JsonProperty(value="html_url")
    String htmlUrl;
    @JsonProperty(value="followers_url")
    String followersUrl;
    @JsonProperty(value="following_url")
    String followingUrl;
    @JsonProperty(value="gists_url")
    String gistsUrl;
    @JsonProperty(value="starred_url")
    String starredUrl;
    @JsonProperty(value="subscriptions_url")
    String subscriptionsUrl;
    @JsonProperty(value="organizations_url")
    String organizationsUrl;
    @JsonProperty(value="repos_url")
    String reposUrl;
    @JsonProperty(value="events_url")
    String eventsUrl;
    @JsonProperty(value="received_events_url")
    String receivedEventsUrl;
    @JsonProperty(value="type")
    String type;
    @JsonProperty(value="site_admin")
    boolean siteAdmin;
    @JsonProperty(value="name")
    String name;
    @JsonProperty(value="company")
    String company;
    @JsonProperty(value="blog")
    String blog;
    @JsonProperty(value="location")
    String location;
    @JsonProperty(value="email")
    String email;
    @JsonProperty(value="hireable")
    String hireable;
    @JsonProperty(value="bio")
    String bio;
    @JsonProperty(value="twitter_username")
    String twitterUsername;
    @JsonProperty(value="public_repos")
    int publicRepos;
    @JsonProperty(value="public_gists")
    int publicGists;
    @JsonProperty(value="followers")
    int followers;
    @JsonProperty(value="following")
    int following;
    @JsonProperty(value="created_at")
    LocalDateTime createdAt;
    @JsonProperty(value="updated_at")
    LocalDateTime updatedAt;
}
