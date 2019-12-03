package com.example.mobilechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.mobilechat.pagers.FriendsFragment;
import com.example.mobilechat.pagers.InformationFragment;
import com.example.mobilechat.pagers.MyFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg_main;
    private FrameLayout fl_main;
    private ArrayList<BasePager> basePagers;
    /**
     * 记录页面位置
     */
    private int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        init();
        initView();
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (this.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE}, 0);
            } else {
                initView();
            }
        } else {
            initView();
        }
    }

    private void initView() {
        basePagers = new ArrayList<>();
        rg_main = findViewById(R.id.rg_main);
        fl_main = findViewById(R.id.fl_main);
        basePagers.add(new InformationFragment(this));
        basePagers.add(new FriendsFragment(this));
        basePagers.add(new MyFragment(this));
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        setFragment();
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                default:
                    position = 0;
                    break;
                case R.id.rb_friend:
                    position = 1;
                    break;
                case R.id.rb_my:
                    position = 2;
                    break;
            }
            setFragment();
        }
    }

    private void setFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, new RepalceFragment(basePagers.get(position)));
        fragmentTransaction.commit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 0:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    initView();
                }else {
                    init();
                }
                break;
        }
    }
}
