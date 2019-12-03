package com.example.mobilechat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MiddleActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button btn_sure,btn_choose;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);
        getSupportActionBar().hide();
        initView();

    }

    private void initView() {
        imageView = findViewById(R.id.imageView);
        btn_sure = findViewById(R.id.btn_sure);
        btn_choose = findViewById(R.id.btn_choose);
        int tx = PreferencesHelp.getInt(this, "tx");
        String tx1 = PreferencesHelp.getVal(this, "tx1");
        Uri parse = Uri.parse(tx1);
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferencesHelp.putVal(MiddleActivity.this,"tx1", String.valueOf(uri));
                finish();
            }
        });
        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,0);
            }
        });
        if (parse != null) {
            Glide.with(this).load(parse).into(imageView);
        }else {
            imageView.setImageResource(tx);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0:
                if (data==null){
                    return;
                }else {
                    uri = data.getData();
                    imageView.setImageURI(uri);
                }
                break;
        }
    }
}
