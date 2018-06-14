package com.example.kbl.githubappcopy.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * model class of the owner, needed to call fromJson
 */
public class Owner extends RealmObject {

    @PrimaryKey
    private String id;
    private String login;
    private String avatar_url;
    private String public_repos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(String public_repos) {
        this.public_repos = public_repos;
    }
}
