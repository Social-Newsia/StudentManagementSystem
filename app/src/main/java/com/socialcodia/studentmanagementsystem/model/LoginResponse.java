package com.socialcodia.studentmanagementsystem.model;

public class LoginResponse {
    boolean error ;
    String message;
    UserModel user;

    public LoginResponse() {
    }

    public LoginResponse(boolean error, String message, UserModel user) {
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
