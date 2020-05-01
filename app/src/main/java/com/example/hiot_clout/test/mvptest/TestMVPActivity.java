package com.example.hiot_clout.test.mvptest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiot_clout.R;
import com.example.hiot_clout.test.fragmenttest.TestFragment;
import com.example.hiot_clout.ui.base.BaseActivity;
import com.example.hiot_clout.test.mvptest.model.User;

import javax.inject.Inject;

public class TestMVPActivity extends BaseActivity<TestView , TestPresenter> implements TestView{

    @Inject
    TestPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        getActivityComponent().inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_mvp);
        final EditText etUserName = findViewById(R.id.et_user_name);
        final EditText etPassword = findViewById(R.id.et_password);
        Button btLogin = findViewById(R.id.bt_login);
        final User user = new User();
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果是mvc的做法是在这里做身份校验
                user.setName(etUserName.getText().toString());
                user.setPassword(etPassword.getText().toString());
                presenter.login(user);
            }
        });

    }

    @Override
    public TestPresenter createPresenter() {
         return presenter;
    }

    @Override
    public void injectIndependies() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
