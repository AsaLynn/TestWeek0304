package com.example.demonstrate.appliaction;

import android.app.Application;
import android.content.Context;

import com.example.demonstrate.utils.UIUtils;

/**
 * Created by think on 2018/3/26.
 */

public class CommonApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initUIUtils(this);
    }

    private void initUIUtils(Context context) {
        UIUtils.init(context);
    }
}
