package com.example.kbl.a5asecvisu.presenter.VO;

import java.io.Serializable;

public class HistoryDetailVO implements Serializable{

    private String name;
    private String solde;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
