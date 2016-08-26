package com.example.jungle.myrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jungle.myrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jungle on 2016/8/18.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int LIST_HEADER=1;
    public static final int LIST_CONTENT=2;
    public static final int LIST_BOTTOM=3;

    private Context context;
    private List<String> list=new ArrayList<>();
    public MyAdapter(Context context,List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){// 列头
            return  LIST_HEADER;
        }else if (position>0 && position<list.size()-1) {
            return LIST_CONTENT;// 列表内容
        }
        else if (position==list.size()-1) {
            return LIST_BOTTOM;// 列尾
        }
        else {
            return -1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==LIST_HEADER){// 标题
            View view = LayoutInflater.from(context).inflate(R.layout.layout_header, null);
            return new HeaderViewHolder(view);

        }else if (viewType==LIST_CONTENT) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_news_item, null);
            return new ContentViewHolder(view);
        }
        else if (viewType==LIST_BOTTOM) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_bottom, null);
            return new BottomViewHolder(view);
        }
        else {
            return null;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ContentViewHolder) {
            ContentViewHolder header_holder;
            header_holder = (ContentViewHolder)holder;
            header_holder.tv_title.setText(list.get(position));
            header_holder.tv_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItem.ClickItem("title");
                }
            });
        }else if(holder instanceof HeaderViewHolder){

        }else{

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ContentViewHolder extends RecyclerView.ViewHolder{
        //private SimpleDraweeView image_icon;
        private TextView tv_title;
        private TextView tv_content;

        public ContentViewHolder(View itemView) {
            super(itemView);
            tv_title=(TextView)itemView.findViewById(R.id.tv_title);
            tv_content=(TextView)itemView.findViewById(R.id.tv_content);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    class BottomViewHolder extends RecyclerView.ViewHolder{

        public BottomViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface OnClickItem{
         void ClickItem(String title);
    }
    private OnClickItem onClickItem;
    public void setOnClickItem(OnClickItem onClickItem){
        this.onClickItem=onClickItem;
    }
}
