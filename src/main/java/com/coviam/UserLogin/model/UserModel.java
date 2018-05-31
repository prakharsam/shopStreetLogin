package com.coviam.UserLogin.model;

import javax.persistence.*;

@Entity
@Table(name = "usertable")
public class UserModel {

    @Id
    @Column(name = "userId")
    @SequenceGenerator(name = "name_of_the_sequence", allocationSize = 1, sequenceName = "name_of_the_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_of_the_sequence")
    private long userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
//    @Column(name = "enabled")
//    private boolean enabled;
//
//    public UserModel() {
//        super();
//        this.enabled=false;
//    }


    public UserModel() {
    }

    public UserModel(long userId, String userName, String password, String name, String address, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.address = address;
        this.email = email;
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
