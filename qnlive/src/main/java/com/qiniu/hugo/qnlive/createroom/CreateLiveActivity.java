package com.qiniu.hugo.qnlive.createroom;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.qiniu.hugo.qnlive.R;



public class CreateLiveActivity extends AppCompatActivity {
    private View mSetCoverView;
    private ImageView mCoverImg;
    private TextView mCoverTipTxt;
    private EditText mTitleEt;
    private TextView mCreateRoomBtn;
    private TextView mRoomNoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

        findAllViews();
        setListeners();
        setupTitlebar();
    }

    private void findAllViews() {
        mSetCoverView = findViewById(R.id.set_cover);
        mCoverImg = (ImageView) findViewById(R.id.cover);
        mCoverTipTxt = (TextView) findViewById(R.id.tv_pic_tip);
        mTitleEt = (EditText) findViewById(R.id.title);
        mCreateRoomBtn = (TextView) findViewById(R.id.create);
        mRoomNoText = (TextView) findViewById(R.id.room_no);
    }

    private void setListeners() {
        mSetCoverView.setOnClickListener(clickListener);
        mCreateRoomBtn.setOnClickListener(clickListener);
    }

    private void setupTitlebar() {
        Toolbar titlebar = (Toolbar) findViewById(R.id.titlebar);
        titlebar.setTitle("开始我的直播");
        titlebar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(titlebar);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.create) {
                //创建直播
                requestCreateRoom();
            } else if (id == R.id.set_cover) {
                //选择图片
                //choosePic();
            }
        }
    };

    private void requestCreateRoom() {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
    }
}
