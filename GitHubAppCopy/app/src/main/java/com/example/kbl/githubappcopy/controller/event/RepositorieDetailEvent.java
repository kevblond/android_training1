package com.example.kbl.githubappcopy.controller.event;

import com.example.kbl.githubappcopy.model.Repositorie;

public class RepositorieDetailEvent {
    protected Repositorie repositorie;

    public RepositorieDetailEvent() {
        this.repositorie = new Repositorie();
    }

    public Repositorie getRepositorie() {
        return repositorie;
    }

    public void setRepositorie(Repositorie listRepositories) {
        this.repositorie = listRepositories;
    }
}
