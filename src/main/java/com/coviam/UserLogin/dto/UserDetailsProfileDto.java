package com.coviam.UserLogin.dto;

public class UserDetailsProfileDto {

    private long userId;
    private String userName;
    private String name;
    private String address;
    private String email;
    private boolean response;

    public UserDetailsProfileDto(long userId, String userName, String name, String address, String email, boolean response) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.address = address;
        this.email = email;
        this.response = response;
    }

    public UserDetailsProfileDto() {
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
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
