package com.example.mobilechat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * create by XinDong
 * on 2019年11月25日16:13:28
 * at
 **/
public class RepalceFragment extends Fragment {
    BasePager basePager ;

    public RepalceFragment(BasePager basePager) {
        this.basePager = basePager;
    }

    @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        BasePager basePager = getBasePager();
        if (basePager!=null){
            return basePager.rootView;
        }
        return null;
    }
    private BasePager getBasePager() {
        if (basePager!=null && !basePager.isInitData){
            basePager.isInitData = true;
            basePager.initData();
        }
        return basePager;
    }
    }
