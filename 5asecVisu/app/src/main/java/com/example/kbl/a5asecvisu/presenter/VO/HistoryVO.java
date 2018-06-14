package com.example.kbl.a5asecvisu.presenter.VO;

import java.io.Serializable;
import java.util.List;

public class HistoryVO implements Serializable{

    private String date;
    private String location;
    private String solde;
    private String country;
    private String numberTicket;
    private String numberShop;
    private List<HistoryDetailVO> listDetail;

    public String getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(String numberTicket) {
        this.numberTicket = numberTicket;
    }

    public String getNumberShop() {
        return numberShop;
    }

    public void setNumberShop(String numberShop) {
        this.numberShop = numberShop;
    }

    public List<HistoryDetailVO> getListDetail() {
        return listDetail;
    }

    public void setListDetail(List<HistoryDetailVO> listDetail) {
        this.listDetail = listDetail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
