package chapter.android.aweme.ss.com.homework.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.R;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

/**
 * 消息列表适配器
 */
public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgViewHolder>{

    private final List<Message> mData;
    private final OnListItemClickListener mListener;

    public MsgAdapter(List<Message> data,OnListItemClickListener listener) {
        this.mData = data;
        this.mListener = listener;

    }

    @NonNull
    @Override
    public MsgAdapter.MsgViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_msg, viewGroup, false);

        return new MsgViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MsgAdapter.MsgViewHolder holder, int i) {
        Message msg = mData.get(i);
        holder.civ_avatar.setImageResource(getIconByType(msg.getIcon()));
        holder.tv_msg.setText(msg.getDescription());
        holder.tv_name.setText(msg.getTitle());
        holder.tv_time.setText(msg.getTime());
        if(msg.isOfficial())
            holder.iv_notice.setImageResource(R.drawable.im_icon_notice_official);
        else
            //如果不这么设置由于viewHolder的复用会导致官方图片显示错误
            holder.iv_notice.setImageDrawable(null);
    }

    /**
     * 通过icon种类获取对应图片资源id
     * @param icon 种类
     * @return 资源id
     */
    private int getIconByType(String icon) {
        int resId = 0;
        switch (icon){
            case "TYPE_ROBOT":
                resId = R.drawable.session_robot;
                break;
            case "TYPE_GAME":
                resId = R.drawable.icon_micro_game_comment;
                break;
            case "TYPE_SYSTEM":
                resId = R.drawable.session_system_notice;
                break;
            case "TYPE_STRANGER":
                resId = R.drawable.session_stranger;
                break;
            case "TYPE_USER":
                resId = R.drawable.icon_girl;
                break;
            default:
                break;
        }
        return resId;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 自定义ViewHolder
     */
    public class MsgViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView tv_name;
        private final TextView tv_msg;
        private final TextView tv_time;
        private final CircleImageView civ_avatar;
        private final ImageView iv_notice;

        MsgViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_msg = itemView.findViewById(R.id.tv_msg);
            tv_time = itemView.findViewById(R.id.tv_time);
            civ_avatar = itemView.findViewById(R.id.civ_avatar);
            iv_notice = itemView.findViewById(R.id.iv_notice);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(mListener != null)
                mListener.onListItemClick(mData.get(position).getTitle());
        }
    }

    public interface OnListItemClickListener{
        //将对话对象姓名带回Exercise3,跳转时需要携带
        void onListItemClick(String name);
    }
}
