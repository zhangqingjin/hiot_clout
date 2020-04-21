package com.example.hiot_clout.test.mvptest;

import com.example.hiot_clout.base.BasePresenter;
import com.example.hiot_clout.test.mvptest.model.User;

public class TestPresenter extends BasePresenter<TestView> {

    public TestPresenter(){
    }

    public void login(User user) {
        if("zhang".equals(user.getUserName()) && "123".equals(user.getPassword())){
            getView().showMessage("登录成功");
        }else{
            getView().showMessage("登录失败");
        }

    }

}
