package com.example.mobilechat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;

public class WelcomeActivity extends AppCompatActivity {

    private Handler mHandler=new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();
        final String username=PreferencesHelp.getVal(getApplicationContext(),"username");
        final String password=PreferencesHelp.getVal(getApplicationContext(),"password");
        if (!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(password)){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    gotoMainActivity(username,password);
                }
            },1000);
        }else{
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    gotoLoginActivity();
                }
            },1000);
        }

    }

    private void gotoLoginActivity() {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private void gotoMainActivity(String username,String password){
            Intent intent=new Intent(this,MainActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("password",password);
            startActivity(intent);
            finish();
        }

}
