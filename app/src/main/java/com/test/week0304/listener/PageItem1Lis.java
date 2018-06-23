package com.test.week0304.listener;

import android.app.Activity;

import com.example.demonstrate.adapter.testname.p1.w4.BaseT3P1W4ILis;
import com.test.week0304.R;
import com.test.week0304.activity.Test1Activity;

/**
 * Created by think on 2018/3/26.
 */

public class PageItem1Lis extends BaseT3P1W4ILis {

    public PageItem1Lis(Activity activity) {
        super(activity);
    }

    @Override
    public Class<?> getStartActivity(int which) {
        if (which == 0) {
            return Test1Activity.class;
        } else if (which == 1) {

        }
        return null;
    }

    @Override
    public int getDialogListId() {
        return R.array.test3_week4_dialog1_items;
    }
}
