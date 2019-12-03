package com.example.mobilechat;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.mobilechat.utils.GetFormatDate;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;


public class MyAdapter extends RecyclerView.Adapter<AppHolder> {

    public List<MessageInfo> list;
    public Context mContext;

    public MyAdapter(List<MessageInfo> messageInfo,Context context) {
        this.list = messageInfo;
        this.mContext = context;
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    //按钮的监听接口
    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }


    @Override
    public AppHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 10) {
            View view = View.inflate(parent.getContext(), R.layout.item_app, null);
            AppHolder holder = new AppHolder(view);
            holder.fileImage =  view.findViewById(R.id.msg_iv);
            holder.msg =  view.findViewById(R.id.msg_tv);
            holder.msg_time =  view.findViewById(R.id.msg_time);
            holder.item_ll =  view.findViewById(R.id.item_ll);
            holder._iv = view.findViewById(R.id.leader_iv);
            return holder;
        } else {
            View view = View.inflate(parent.getContext(), R.layout.item_app2, null);
            AppHolder holder = new AppHolder(view);
            holder.fileImage =  view.findViewById(R.id.msg_iv2);
            holder.msg =  view.findViewById(R.id.msg_tv2);
            holder.msg_time =  view.findViewById(R.id.msg_time2);
            holder.item_ll =  view.findViewById(R.id.item_ll2);
            holder._iv = view.findViewById(R.id.soldier_iv);
            return holder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        int type = list.get(position).getType();
        return type;
    }

    @Override
    public void onBindViewHolder(final AppHolder holder, final int position) {
        MessageInfo appInfo = list.get(position);
        holder.msg.setText(appInfo.getMsg());
        String date = appInfo.getDate();
        holder.msg_time.setText(date);
        int touxaign = appInfo.getTouxaign();
        holder._iv.setImageResource(touxaign);
        if (onItemClickListener != null) {
            //点击事件
            holder.item_ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holder.itemView, position);
                }
            });
            //长按的点击事件
            holder.item_ll.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemClickListener.onItemLongClick(holder.itemView, position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class AppHolder extends RecyclerView.ViewHolder {
    public ImageView fileImage;
    public TextView msg, msg_time;
    public LinearLayout item_ll;
    public CircleImageView _iv;
    public AppHolder(View itemView) {
        super(itemView);
    }
}
