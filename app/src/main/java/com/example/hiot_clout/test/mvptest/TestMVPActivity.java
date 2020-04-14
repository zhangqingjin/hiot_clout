package com.example.hiot_clout.test.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiot_clout.R;
import com.example.hiot_clout.test.mvptest.model.User;

public class TestMVPActivity extends AppCompatActivity implements TestView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mvp);
        final EditText etName = findViewById(R.id.et_name);
        final EditText etPassword = findViewById(R.id.et_password);
        Button btLogin = findViewById(R.id.bt_login);
        final User user = new User();
        final TestPresenter presenter = new TestPresenter(this);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果是mvc的做法是在这里做身份校验
                user.setName(etName.getText().toString());
                user.setPassword(etPassword.getText().toString());
                presenter.login(user);
            }
        });
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
