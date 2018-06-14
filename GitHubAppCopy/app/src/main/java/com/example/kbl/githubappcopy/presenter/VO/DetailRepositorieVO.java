package com.example.kbl.githubappcopy.presenter.VO;

import java.io.Serializable;

/**
 * VO used for a view of a detailed repositorie
 */
public class DetailRepositorieVO implements Serializable {
    private String fullName;
    private String avatarUrl;
    private String Description;

    public DetailRepositorieVO(String fullName, String avatarUrl, String description) {
        this.fullName = fullName;
        this.avatarUrl = avatarUrl;
        Description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

