package com.test.week0304.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.week0304.R;

/**
 * Created by think on 2018/3/26.
 */

public class PersonItemView extends LinearLayout {

    protected TextView titleTv;
    protected TextView contentTv;
    protected View rootView;
    protected ImageView contentIv;
    private String mTitle = "";
    private String mContent;
    private boolean mShowContent;
    private boolean mShowContentImg;
    private Drawable mContenDrawable;

    public PersonItemView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public PersonItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public PersonItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }


    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
//        LayoutInflater
//                .from(context)
//                .inflate(R.layout.layout_person_item, this);
        LayoutInflater
                .from(context)
                .inflate(R.layout.layout_person_item, this, true);
        titleTv = (TextView) findViewById(R.id.title_tv);
        contentTv = findViewById(R.id.content_tv);
        contentIv = findViewById(R.id.content_iv);
        readAttributeSet(context, attrs, defStyleAttr);
    }

    private void readAttributeSet(Context context, AttributeSet attrs, int defStyleAttr) {
//        final TypedArray typedArray
//                = context
//                .obtainStyledAttributes(
//                        attrs,
//                        R.styleable.PersonItemView,
//                        defStyleAttr, 0);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PersonItemView);
        if (null != typedArray) {
            mTitle = typedArray.getString(R.styleable.PersonItemView_title);
            titleTv.setText(mTitle);
            mShowContent = typedArray.getBoolean(R.styleable.PersonItemView_showContent, true);
            if (mShowContent) {
                contentTv.setVisibility(VISIBLE);
                mContent = typedArray.getString(R.styleable.PersonItemView_content);
                contentTv.setText(mContent);
            } else {
                contentTv.setVisibility(GONE);
            }

            mShowContentImg = typedArray.getBoolean(R.styleable.PersonItemView_showContentImg, false);
            if (mShowContentImg) {
                contentIv.setVisibility(VISIBLE);
                mContenDrawable = typedArray.getDrawable(R.styleable.PersonItemView_content_src);
                if (null != mContenDrawable) {
                    contentIv.setImageDrawable(mContenDrawable);
                }
                //contentIv.setImageResource();
            } else {
                contentIv.setVisibility(GONE);
            }
            typedArray.recycle();
        }
    }


}
