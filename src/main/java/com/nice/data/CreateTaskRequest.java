package com.nice.data;

import com.nice.domain.User;
/**
 * Created by deepesh nellutla on 2/23/2017.
 */


public class CreateTaskRequest {

    String name;

    String description;

    Status status;

    User user;

    public CreateTaskRequest(String name, String description, Status status,User user){
        this.name = name;
        this.description = description;
        this.status = status;
        this.user = user;
    }

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
