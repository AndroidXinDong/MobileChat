package com.example.mobilechat.pagers;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mobilechat.BasePager;
import com.example.mobilechat.LoginActivity;
import com.example.mobilechat.MiddleActivity;
import com.example.mobilechat.PreferencesHelp;
import com.example.mobilechat.R;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class MyFragment extends BasePager {
    private View mView = null;
    private Button btn_quit;
    private ImageView images_head;
    private SwipeRefreshLayout  swp;
    public MyFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        mView = View.inflate(mContext, R.layout.my_fragment, null);
        btn_quit = mView.findViewById(R.id.btn_quit);
        images_head = mView.findViewById(R.id.images_head);
        swp = mView.findViewById(R.id.swp);
        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LoginActivity.class);
                mContext.startActivity(intent);
            }
        });
        images_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MiddleActivity.class);

                mContext.startActivity(intent);
            }
        });

        swp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                String tx1 = PreferencesHelp.getVal(mContext, "tx1");
                Log.i("Tag", "onRefresh: "+tx1);
                Uri parse = Uri.parse(tx1);
                if (parse != null) {
                    Log.i("Tag", "onRefresh: "+parse);
                    Glide.with(mContext).load(parse).into(images_head);
                }

                swp.setRefreshing(false);
            }
        });
        return mView;

    }

    @Override
    public void initData() {

    }

}
