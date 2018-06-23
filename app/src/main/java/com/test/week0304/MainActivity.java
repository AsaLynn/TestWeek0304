package com.test.week0304;

import com.example.demonstrate.DialogPage;
import com.example.demonstrate.FirstActivity;
import com.test.week0304.listener.PageItem1Lis;

public class MainActivity extends FirstActivity {

    @Override
    protected void click0() {
        DialogPage.getInstance()
                .setOnDialogItemListener(new PageItem1Lis(this));
    }
}
