package com.example.kbl.githubappcopy.presenter.VO;

import java.io.Serializable;

/**
 * VO used for the recyclerView of the Main layout
 */
public class RepositorieVO implements Serializable {
    private String id;
    private String name;
    private String fullName;
    private int watchers;
    private String language;
    private String Description;
    private String avatarUrl;

    public RepositorieVO(String id, String name, String fullName, int watchers, String language, String description, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.watchers = watchers;
        this.language = language;
        Description = description;
        this.avatarUrl = avatarUrl;
    }

    ///////////////////////////////////////////////////////////////////////////
    // getter & setter
    ///////////////////////////////////////////////////////////////////////////

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

}

