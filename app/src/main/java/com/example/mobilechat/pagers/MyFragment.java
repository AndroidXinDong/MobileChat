package com.example.mobilechat.pagers;

import android.content.Context;
import android.view.View;

import com.example.mobilechat.BasePager;
import com.example.mobilechat.R;

public class MyFragment extends BasePager {
    private View mView = null;


    public MyFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        mView = View.inflate(mContext,R.layout.my_fragment,null);
        return mView;
    }
}
