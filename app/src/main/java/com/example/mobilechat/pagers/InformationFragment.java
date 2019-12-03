package com.example.mobilechat.pagers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mobilechat.BasePager;
import com.example.mobilechat.ChatActivity;
import com.example.mobilechat.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class InformationFragment extends BasePager {
    private View mView;
    private ListView lv_message;
    private ArrayList<TempBean> mList = null;
    private InfoAdapter mInfoAdapter;
    private int [] imageId = {R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d};

    public InformationFragment(Context context) {
        super(context);
    }


    @Override
    public View initView() {
        mView = View.inflate(mContext, R.layout.information_fragment, null);
        lv_message = mView.findViewById(R.id.lv_message);
        lv_message.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, ChatActivity.class);
                intent.putExtra("bean",mList.get(position));

                mContext.startActivity(intent);
            }
        });
        return mView;
    }

    @Override
    public void initData() {
        mList = new ArrayList<>();
        addData();
        mInfoAdapter = new InfoAdapter();
        lv_message.setAdapter(mInfoAdapter);
    }

    private void addData() {
        mList.add(new TempBean(imageId[0],"阳光下，闪动的四叶草","没有问题，这个事情明天给你答复","16:35:26"));
        mList.add(new TempBean(imageId[1],"洪荒少女","你好","10:35:26"));
        mList.add(new TempBean(imageId[2],"放羊的星星","love love","昨天"));
        mList.add(new TempBean(imageId[3],"Whish","泾渭分明，努力而自由","前天"));
    }

    class InfoAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.main_item, null);
                holder = new ViewHolder();
                convertView.setTag(holder);
                holder.civ_touxiang = convertView.findViewById(R.id.civ_touxiang);
                holder.tv_main_name = convertView.findViewById(R.id.tv_main_name);
                holder.tv_main_msg = convertView.findViewById(R.id.tv_main_msg);
                holder.tv_main_date = convertView.findViewById(R.id.tv_main_date);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.civ_touxiang.setImageResource(mList.get(position).getImgID());
            holder.tv_main_name.setText(mList.get(position).getName());
            holder.tv_main_msg.setText(mList.get(position).getTempMsg());
            holder.tv_main_date.setText(mList.get(position).getDate());

            return convertView;
        }

        class ViewHolder {
            CircleImageView civ_touxiang;
            TextView tv_main_name, tv_main_msg, tv_main_date;
        }
    }
}