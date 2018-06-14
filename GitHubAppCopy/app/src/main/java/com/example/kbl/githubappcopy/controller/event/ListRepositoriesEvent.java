package com.example.kbl.githubappcopy.controller.event;

import com.example.kbl.githubappcopy.model.Repositorie;

import java.util.ArrayList;
import java.util.List;

/**
 * event of controller when the list has been correctly download
 */
public class ListRepositoriesEvent {
    private List<Repositorie> listRepositories;

    public ListRepositoriesEvent() {
        this.listRepositories = new ArrayList<>();
    }

    public List<Repositorie> getListRepositories() {
        return listRepositories;
    }

    public void setListRepositories(List<Repositorie> listRepositories) {
        this.listRepositories = listRepositories;
    }
}
