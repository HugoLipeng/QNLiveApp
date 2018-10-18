package com.qiniu.hugo.qnlive.livelist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.qiniu.hugo.qnlive.R;


/**
 * Created by Administrator.
 */

public class LiveListFragment extends Fragment {

    private ListView mLiveListView;
    //private LiveListAdapter mLiveListAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_live_list, container, false);

        findAllViews(view);
        requestLiveList();

        return view;
    }

    private void requestLiveList() {

    }

    private void findAllViews(View view) {

        Toolbar titlebar = (Toolbar) view.findViewById(R.id.titlebar);
        titlebar.setTitle("热播列表");
        titlebar.setTitleTextColor(Color.WHITE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(titlebar);

        mLiveListView = (ListView) view.findViewById(R.id.live_list);
        //mLiveListAdapter = new LiveListAdapter(getContext());
        //mLiveListView.setAdapter(mLiveListAdapter);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout_list);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //请求服务器，获取直播列表
                requestLiveList();
            }
        });
    }


}