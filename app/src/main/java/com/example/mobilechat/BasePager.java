package com.example.mobilechat;

import android.content.Context;
import android.view.View;

public abstract class BasePager {
    /**
     * 上下文
     */
    public Context mContext;

    /**
     * 视图 各个子页面实例化的结果
     */
    public View rootView;

    public  boolean isInitData = false;
    public BasePager(Context context) {
        this.mContext = context;
        rootView = initView();
        isInitData =false;
    }

    /**
     * 强制孩子实现该方法，完成特定的效果
     * @return
     */
    public abstract View initView();

    /**
     * 当孩子需要初始化数据的时候 重写该方法 用于请求数据 或者显示数据
     */
    public void initData(){}

}
