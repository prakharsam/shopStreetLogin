package com.coviam.UserLogin.dto;

public class ReturnDto {

    private long userId;
    private String userName;
    private String name;
    private String address;
    private String email;

    public ReturnDto(long userId, String userName, String name, String address, String email) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public ReturnDto() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
