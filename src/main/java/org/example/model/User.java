package org.example.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {
    @SerializedName("Name")
    private String name;
    @SerializedName("BirthDate")
    private Date birthDate;
    @SerializedName("LoginNumber")
    private int loginNumber;

    public User(){}
    public User(String name, Date birthDate, int loginNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.loginNumber = loginNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getLoginNumber() {
        return loginNumber;
    }

    public void setLoginNumber(int loginNumber) {
        this.loginNumber = loginNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", loginNumber=" + loginNumber +
                '}';
    }
}
