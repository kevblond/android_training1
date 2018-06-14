package com.example.kbl.githubappcopy.controller.event;

/**
 * event listened if a wrong login has been entered
 */
public class LoginFailedEvent {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
