package com.example.tests;

public class User {
    private int userID;
    private String userFullName;
    private String userGender;
    private String userBirthDate;
    private String userCity;
    private String userMobile;
    private String userEmail;
    private String userPassword;

    public User() {
        userID = -1;
    }

    public User(String fullName, String gender, String birthDate, String city, String mobile, String email, String password) {
        userFullName = fullName;
        userGender = gender;
        userBirthDate = birthDate;
        userCity = city;
        userMobile = mobile;
        userEmail = email;
        userPassword = password;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int i) {
        userID = i;
    }

    public String getFullName() {
        return userFullName;
    }

    public void setFullName(String fn) {
        userFullName = fn;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String g) {
        userGender = g;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String b) {
        userBirthDate = b;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String c) {
        userCity = c;
    }

    public String getMobile() {
        return userMobile;
    }

    public void setMobile(String m) {
        userMobile = m;
    }

    public String getEMail() {
        return userEmail;
    }

    public void setEMail(String e) {
        userEmail = e;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String p) {
        userPassword = p;
    }
}
/*
    @Override
    public String toString() {
        return "User{" +
                "id=" + userID +
                ", email='" + userEmail + '\'' +
                ", password='" + userPassword + '\'' +
                ", password='" + userPassword + '\'' +
                ", password='" + userPassword + '\'' +
                ", password='" + userPassword + '\'' +
                ", password='" + userPassword + '\'' +
                '}';
    }
}*/