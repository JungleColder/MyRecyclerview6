package com.example.jungle.myrecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jungle.myrecyclerview.adapter.MyAdapter;
import com.example.jungle.myrecyclerview.utils.OnRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    RecyclerView mRecyclerView;
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerview);

        initData();

        MyAdapter myAdapter=new MyAdapter(this,list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        布局样式
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));

        mRecyclerView.setAdapter(myAdapter);

        //实现RecyclerView的item事件方法一
        myAdapter.setOnClickItem(new MyAdapter.OnClickItem() {
            @Override
            public void ClickItem(String title) {
                Bundle mBundle = new Bundle();
                Intent mIntent = new Intent();
                mIntent.setClass(MainActivity.this, SecondActivity.class);
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });
        //实现RecyclerView的item事件方法二
        mRecyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(mRecyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                Bundle mBundle = new Bundle();
                Intent mIntent = new Intent();
                mIntent.setClass(MainActivity.this, SecondActivity.class);
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });

    }

    private void initData() {
        list.add("");
        for (int i = 0; i < 13; i++) {
            list.add("title"+i);
        }
        list.add("");
    }
}
