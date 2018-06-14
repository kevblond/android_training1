package com.example.kbl.githubappcopy.controller.event;

/**
 * event listened if a correct login has been entered
 */
public class LoginSucceededEvent {
    protected String userName;

    public LoginSucceededEvent() {
        this.userName = "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
