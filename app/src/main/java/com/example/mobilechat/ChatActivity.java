package com.example.mobilechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilechat.pagers.TempBean;
import com.example.mobilechat.utils.GetFormatDate;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup rg;
    private RecyclerView recyclerview;
    private Button btn_send;
    private EditText et_content;
    private String newPath;
    private ImageButton plus;
    private boolean isPlus = false;
    private LinearLayoutManager mManager;
    private ImageView btn_back;
    private TextView ltdx;
    private String TAG = "Tag";
    private String name, msg, date = null;
    private int imageId;
    private ArrayList<MessageInfo> mList = new ArrayList<>();
    private MyAdapter mAdapter;
    private int selfTX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        mManager = new LinearLayoutManager(this);
        getSupportActionBar().hide();
        initView();
        initData();
    }

    private void initData() {
        mAdapter = new MyAdapter(mList,this);
        recyclerview.setAdapter(mAdapter);
        selfTX = PreferencesHelp.getInt(this,"tx");
    }

    private void initView() {
        recyclerview = findViewById(R.id.recyclerview);
        plus = findViewById(R.id.plus);
        et_content = findViewById(R.id.et_content);
        btn_send = findViewById(R.id.btn_send);
        rg = findViewById(R.id.rg);
        btn_back = findViewById(R.id.btn_back);
        ltdx = findViewById(R.id.ltdx);
        recyclerview.setLayoutManager(mManager);
        Intent intent = getIntent();
        if (intent != null) {
            TempBean bean = (TempBean) intent.getSerializableExtra("bean");
            imageId = bean.getImgID();
            name = bean.getName();
            msg = bean.getTempMsg();
            date = bean.getDate();
            mList.add(new MessageInfo(msg, date,10,imageId));
        }
        ltdx.setText(name);
        //加号的点击事件
        plus.setOnClickListener(this);
        btn_send.setOnClickListener(this);
        btn_back.setOnClickListener(this);

    }

    /**
     * 隐藏软键盘
     */
    private void hideKeyword() {
        //隐藏软件盘
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et_content.getWindowToken(), 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send:
                // 创建一条消息 并刷新
                String content = et_content.getText().toString();
                String date = GetFormatDate.getFormatedDate(System.currentTimeMillis());
                if (!TextUtils.isEmpty(content)) {
                    mList.add(new MessageInfo(content,date,1,selfTX));
                    mAdapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
                }
                if (content.contains("你好")){
                    mList.add(new MessageInfo("你好，很高兴认识你",GetFormatDate.getFormatedDate(System.currentTimeMillis()),10,imageId));
                }
                break;
            case R.id.btn_back:
                ChatActivity.this.finish();
                break;
            case R.id.plus:
                if (!isPlus) {
                    rg.setVisibility(View.VISIBLE);
                } else {
                    rg.setVisibility(View.GONE);
                }
                isPlus = !isPlus;
                //隐藏软键盘
                hideKeyword();
                break;
        }
    }
}
