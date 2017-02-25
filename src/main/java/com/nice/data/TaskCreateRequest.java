package com.nice.data;

import com.nice.domain.User;

/**
 * Created by deepesh nellutla on 2/23/2017.
 */
public class TaskCreateRequest {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    String description;

    String status;

    User user;

}
