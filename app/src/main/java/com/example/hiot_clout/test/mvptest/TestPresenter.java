package com.example.hiot_clout.test.mvptest;

import com.example.hiot_clout.ui.base.BasePresenter;
import com.example.hiot_clout.test.mvptest.dagger2test.ThirdObj;
import com.example.hiot_clout.test.mvptest.model.User;

import javax.inject.Inject;

public class TestPresenter extends BasePresenter<TestView> {
    @Inject
    ThirdObj thirdObj;

    @Inject
    public TestPresenter(){
    }

    public void login(User user) {
        thirdObj.thirdAction();
        if("zhang".equals(user.getUserName()) && "123".equals(user.getPassword())){
            getView().showMessage("登录成功");
        }else{
            getView().showMessage("登录失败");
        }

    }

}
