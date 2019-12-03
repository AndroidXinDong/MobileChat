package com.example.mobilechat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.vondear.rxtools.RxPhotoTool;
import com.vondear.rxtools.RxPictureTool;

import java.io.File;

public class MiddleActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button btn_sure, btn_choose;
    private String picPath;

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
        picPath= PreferencesHelp.getVal(this, "tx1");
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferencesHelp.putVal(MiddleActivity.this, "tx1", picPath);
                finish();
            }
        });
        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = RxPictureTool.getImagePickerIntent();
                startActivityForResult(intent, 0);
            }
        });
        if (picPath != null) {
            BitmapFactory.Options s = new BitmapFactory.Options();
            s.inSampleSize = 2;
            Bitmap bitmap = BitmapFactory.decodeFile(picPath,s);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        } else {
            imageView.setImageResource(tx);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                if (data == null) {
                    return;
                } else {
                    Uri data1 = data.getData();
                    picPath = RxPhotoTool.getRealFilePath(this, data1);
                    BitmapFactory.Options s = new BitmapFactory.Options();
                    s.inSampleSize = 2;
                    Bitmap bitmap = BitmapFactory.decodeFile(picPath,s);
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
                break;
        }
    }
}
