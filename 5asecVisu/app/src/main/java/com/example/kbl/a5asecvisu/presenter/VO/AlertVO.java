package com.example.kbl.a5asecvisu.presenter.VO;

import java.io.Serializable;

public class AlertVO  implements Serializable{
    private String alerte;
    private boolean checkbox;

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public String getAlerte() {
        return alerte;
    }

    public void setAlerte(String alerte) {
        this.alerte = alerte;
    }
}
