package com.kishan00747.truenews.model;

import java.util.ArrayList;

public class User {

    String name;
    String mobileNumber;
    String emailId;
    String password;
    ArrayList<String> categoryList;
    ArrayList<String> sourcesList;

    public User(String name, String mobileNumber, String emailId, String password, ArrayList<String> categoryList, ArrayList<String> sourcesList) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.password = password;
        this.categoryList = categoryList;
        this.sourcesList = sourcesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ArrayList<String> categoryList) {
        this.categoryList = categoryList;
    }

    public ArrayList<String> getSourcesList() {
        return sourcesList;
    }

    public void setSourcesList(ArrayList<String> sourcesList) {
        this.sourcesList = sourcesList;
    }
}
