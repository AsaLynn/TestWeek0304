package com.test.week0304.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.test.week0304.R;
import com.test.week0304.slidemenu.FragmentDefaultMain;
import com.test.week0304.slidemenu.LeftSlidingMenuFragment;
import com.test.week0304.slidemenu.RightSlidingMenuFragment;

public class Test1Activity extends SlidingFragmentActivity implements View.OnClickListener {

    protected SlidingMenu leftRightSlidingMenu;
    private ImageButton ivTitleBtnLeft;
    private ImageButton ivTitleBtnRight;
    private Fragment mContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLeftRightSlidingMenu();
        setContentView(R.layout.activity_test1);

        initView();
    }


    private void initView() {
        ivTitleBtnLeft = (ImageButton) this.findViewById(R.id.ivTitleBtnLeft);
        ivTitleBtnLeft.setOnClickListener(this);
        ivTitleBtnRight = (ImageButton) this.findViewById(R.id.ivTitleBtnRight);
        ivTitleBtnRight.setOnClickListener(this);
    }

    private void initLeftRightSlidingMenu() {
        mContent = new FragmentDefaultMain();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mContent).commit();
        setBehindContentView(R.layout.main_left_layout);
        FragmentTransaction leftFragementTransaction = getSupportFragmentManager().beginTransaction();
        Fragment leftFrag = new LeftSlidingMenuFragment();
        leftFragementTransaction.replace(R.id.main_left_fragment, leftFrag);
        leftFragementTransaction.commit();
        leftRightSlidingMenu = getSlidingMenu();
        leftRightSlidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        leftRightSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        leftRightSlidingMenu.setFadeDegree(0.35f);
        leftRightSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        leftRightSlidingMenu.setShadowDrawable(R.drawable.shadow);
        leftRightSlidingMenu.setFadeEnabled(true);
        leftRightSlidingMenu.setBehindScrollScale(0.333f);

        leftRightSlidingMenu.setSecondaryMenu(R.layout.main_right_layout);
        FragmentTransaction rightFragementTransaction = getSupportFragmentManager().beginTransaction();
        Fragment rightFrag = new RightSlidingMenuFragment();
        leftFragementTransaction.replace(R.id.main_right_fragment, rightFrag);
        rightFragementTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivTitleBtnLeft:
                leftRightSlidingMenu.showMenu();
                break;
            case R.id.ivTitleBtnRight:
                leftRightSlidingMenu.showSecondaryMenu(true);
                break;
            default:
                break;
        }

    }


    public void switchContent(Fragment fragment) {
        mContent = fragment;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        getSlidingMenu().showContent();
    }


}
