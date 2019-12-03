package com.example.mobilechat.pagers;

import android.content.Context;
import android.view.View;

import com.example.mobilechat.BasePager;
import com.example.mobilechat.R;


public class FriendsFragment extends BasePager {
    private View view = null;
    public FriendsFragment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(mContext,R.layout.friends_fragment,null);
        return view;
    }
}
