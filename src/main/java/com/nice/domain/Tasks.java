package com.nice.domain;

import com.nice.data.Status;

import javax.persistence.*;

/**
 * Created by Cigniti_1868 on 2/22/2017.
 */
@Entity
@Table(name = "tasks")
public class Tasks {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //@ManyToOne
    //@JoinColumn(name="user_task_id")
    public User getUser() {
          return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;

    @Enumerated(EnumType.STRING)
    Status status;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_task_id")
    User user;

}

