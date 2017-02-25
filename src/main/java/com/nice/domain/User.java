package com.nice.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Cigniti_1868 on 2/22/2017.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;

    //@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    // public Tasks getTasks() {
    //   return tasks;
    //}

    //  public void setTasks(Tasks tasks) {
    //    this.tasks = tasks;
    //}

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Tasks> tasks;

    protected User() {
    }

    public User(String userName) {
        this.userName = userName;
    }


    @Override
    public String toString() {
        return String.format(
                "User[id=%d, userName='%s']",
                id, userName);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return !(userName != null ? !userName.equals(user.userName) : user.userName != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
