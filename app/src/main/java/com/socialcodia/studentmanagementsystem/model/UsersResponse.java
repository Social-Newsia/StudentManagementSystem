package com.socialcodia.studentmanagementsystem.model;

import java.util.List;

public class UsersResponse {
    private boolean error;
    private List<ModelUser> user;

    public UsersResponse(boolean error, List<ModelUser> user) {
        this.error = error;
        this.user = user;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ModelUser> getUser() {
        return user;
    }

    public void setUser(List<ModelUser> user) {
        this.user = user;
    }
}
