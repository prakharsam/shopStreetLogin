package com.coviam.UserLogin.dto;

import java.io.Serializable;
import java.util.Date;


public class UserDto implements Serializable {

    private String userName;
    private String password;
    private String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDto(String userName, String password, String name, String address) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.address = address;

    }


}
