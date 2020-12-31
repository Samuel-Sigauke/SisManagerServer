package com.prac.recordsmanagerweb.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "public")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String usertype;

    /**
     public User(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public User() {

    }  */


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUsertype() { return usertype; }

    public void setUsertype(String usertype) { this.usertype = usertype; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
