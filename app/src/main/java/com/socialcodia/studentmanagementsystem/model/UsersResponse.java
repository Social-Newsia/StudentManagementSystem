package com.socialcodia.studentmanagementsystem.model;

import java.util.List;

public class UsersResponse {
    private boolean error;
    private List<ModelUser> users;

    public UsersResponse(boolean error, List<ModelUser> users) {
        this.error = error;
        this.users = users;
    }

    public boolean isError() {
        return error;
    }

    public List<ModelUser> getUsers() {
        return users;
    }
}
