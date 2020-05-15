package com.socialcodia.studentmanagementsystem.model;

public class LoginResponse {
    boolean error ;
    String message;
    ModelUser user;

    public LoginResponse() {
    }

    public LoginResponse(boolean error, String message, ModelUser user) {
        this.error = error;
        this.message = message;
        this.user = user;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ModelUser getUser() {
        return user;
    }

    public void setUser(ModelUser user) {
        this.user = user;
    }
}
