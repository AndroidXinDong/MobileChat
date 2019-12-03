package com.example.mobilechat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;

import java.net.URLEncoder;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btGo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        initView();
        setListener();
    }

    private void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btGo = findViewById(R.id.bt_go);
    }

    private void setListener() {
        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = etUsername.getText().toString();
                String passWord = etPassword.getText().toString();
                if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(passWord)) {
                    login(userName, passWord);
                } else {
                    ToastUtils.setBgColor(Color.parseColor("#2fa881"));
                    ToastUtils.setMsgColor(Color.parseColor("#ffffff"));
                    ToastUtils.setMsgTextSize(20);
                    ToastUtils.showShort("请输入账号或密码");
                }

            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void login(String username, String password) {
        ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);
        if (username.equals("sa") && password.equals("123456"))  {
            PreferencesHelp.putVal(getApplicationContext(),"username",username);
            PreferencesHelp.putVal(getApplicationContext(),"password",password);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("password", password);
            startActivity(intent, oc2.toBundle());
            finish();
        }else{
            ToastUtils.setBgColor(Color.parseColor("#2fa881"));
            ToastUtils.setMsgColor(Color.parseColor("#ffffff"));
            ToastUtils.setMsgTextSize(20);
            ToastUtils.showShort("用户名与密码不匹配");
        }

    }
}
