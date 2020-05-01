package com.example.hiot_clout.test.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hiot_clout.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * okhttp测试类
 */
public class TestOkHttpActivity extends AppCompatActivity {

    private static final String basUrl = "http://163.177.151.109";
    private static final String TAG = "TestOkHttpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ok_http);

        //execute测试方法
        Button btnExecute = findViewById(R.id.btn_okhttp_execute);
        btnExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testExecute();
            }
        });
        //enqueue方法测试
        Button btnEnqueue = findViewById(R.id.btn_okhttp_enqueue);
        btnEnqueue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                testEnqueue();
            }
        });
    }


    //测试execute方式
    private void testExecute() {

        new Thread() {
            @Override
            public void run() {
                super.run();
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(basUrl).build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    Log.d(TAG, "run: " + response.body().string() );
                } catch (IOException e) {
                    Log.e(TAG, "testExecute: " + e.getMessage(), e);
                }
            }
        }.start();
    }
    //enqueue方法测试
    private void testEnqueue() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(basUrl).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "onFailure: "+ e.getMessage(), e );
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(TAG, "onResponse: " + response.body().string());
            }
        });
    }
}
