package com.example.hiot_clout.test.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiot_clout.R;
import com.example.hiot_clout.base.BaseActivity;
import com.example.hiot_clout.base.BasePresenter;
import com.example.hiot_clout.test.mvptest.dagger2test.DaggerPresenterComponent;
import com.example.hiot_clout.test.mvptest.dagger2test.PresenterComponent;
import com.example.hiot_clout.test.mvptest.model.User;

import javax.inject.Inject;

public class TestMVPActivity extends BaseActivity<TestView , TestPresenter> implements TestView{

    @Inject
    TestPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getComponent().inject(this);
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
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 创建注入器
     * @return
     */
    public PresenterComponent getComponent(){
        return DaggerPresenterComponent.builder().build();
    }
}
