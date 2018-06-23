/*
 * $filename: AboutActivity.java,v $
 * $Date: 2013-12-23  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package com.test.week0304.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.week0304.R;
import com.test.week0304.widget.PersonItemView;


public class AboutActivity extends AppCompatActivity implements OnClickListener {

    protected ImageView leftIv;
    protected TextView titleTv;
    protected Toolbar toolbar;
    protected PersonItemView headerPiv;
    protected PersonItemView nicknamePiv;
    protected PersonItemView phonePiv;
    protected PersonItemView namePiv;
    protected PersonItemView sexPiv;
    protected PersonItemView morePiv;
    protected TextView outTv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_person_data);
        initView();
        initToolbar();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aboutTitleBtnLeft:
                this.finish();
                break;
            case R.id.aboutTitleBtnRight:
                break;
            default:
                break;
        }
    }

    private void initView() {
        leftIv = (ImageView) findViewById(R.id.left_iv);
        leftIv.setVisibility(View.VISIBLE);
        titleTv = (TextView) findViewById(R.id.title_tv);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        headerPiv = (PersonItemView) findViewById(R.id.header_piv);
        nicknamePiv = (PersonItemView) findViewById(R.id.nickname_piv);
        phonePiv = (PersonItemView) findViewById(R.id.phone_piv);
        namePiv = (PersonItemView) findViewById(R.id.name_piv);
        sexPiv = (PersonItemView) findViewById(R.id.sex_piv);
        morePiv = (PersonItemView) findViewById(R.id.more_piv);
        outTv = (TextView) findViewById(R.id.out_tv);
    }

    private void initToolbar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleTv.setVisibility(View.VISIBLE);
        titleTv.setText("个人信息");
    }
}
