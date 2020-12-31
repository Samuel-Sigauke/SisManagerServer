package com.prac.recordsmanagerweb.dto;

import lombok.Data;

@Data
public class UserDto {

    //private int id;
    private String username;
    private String password;
    private String usertype;

    /**
    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getUserType() { return userType; }

    public void setUserType(String userType) { this.userType = userType; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; } */

}

