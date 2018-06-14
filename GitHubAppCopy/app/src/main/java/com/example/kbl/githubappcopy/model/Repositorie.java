package com.example.kbl.githubappcopy.model;

import javax.annotation.PropertyKey;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * model class of a Repositorie, used for fromJson method
 */
public class Repositorie extends RealmObject {

    //Field
    @PrimaryKey
    private String id;
    @PropertyKey
    private Owner owner;
    private String description;
    private String name;
    private String full_name;
    private int watchers;
    private String language;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.owner.setAvatar_url(avatarUrl);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public String getAvatarUrl() {
        return owner.getAvatar_url();
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public int getWatchers() {
        return watchers;
    }

    public String getLanguage() {
        return language;
    }
}
