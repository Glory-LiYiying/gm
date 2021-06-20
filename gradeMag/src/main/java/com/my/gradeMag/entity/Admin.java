package com.my.gradeMag.entity;

public class Admin {
    private String acot;

    private String password;

    public String getAcot() {
        return acot;
    }

    public void setAcot(String acot) {
        this.acot = acot == null ? null : acot.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}