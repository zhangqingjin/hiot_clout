package com.example.hiot_clout.test.networktest;

import java.io.Serializable;

//用户对象
public class UserBean implements Serializable {
    /**
     * 用户名称
     */
    private String username;
    /**
     *邮箱地址
     */
    private String email;
    /**
     *密码
     */
    private String password;
    /**
     *用户类型
     */
    private String userType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
