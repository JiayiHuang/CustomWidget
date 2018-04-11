package com.hjy.customwidgets.flipcard.drawable.implementation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.hjy.customwidgets.R;

/**
 * <pre>
 *     author : HJY
 *     time   : 2017/12/11/15:24
 *     desc   : 文件描述
 *     version: 当前版本号
 * </pre>
 */
public class FlipCardDrawableActivity extends AppCompatActivity {
    private AnimatorSet mRightOutSet;
    private AnimatorSet mLeftInSet;
    private FrameLayout mFlFront,mFlBack;
    private boolean isClickable,isBackside;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_card_drawable);
        mFlFront = (FrameLayout) findViewById(R.id.fl_front);
        mFlBack = (FrameLayout) findViewById(R.id.fl_back);
        isClickable = true;
        initAnimators();
        setCameraDistance();
    }

    private void setCameraDistance() {
        float distance = getResources().getDisplayMetrics().density*200000;
        mFlFront.setCameraDistance(distance);
        mFlBack.setCameraDistance(distance);
    }

    private void initAnimators() {
        mRightOutSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.anim_right_out);
        mLeftInSet = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.anim_left_in);
        mRightOutSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                isClickable = false;
            }
        });
        mLeftInSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                isClickable = true;
            }
        });
    }

    public void flipCard(View view) {
        if (isClickable){
            if (!isBackside){//当前正面
                mRightOutSet.setTarget(mFlFront);
                mLeftInSet.setTarget(mFlBack);
                mRightOutSet.start();
                mLeftInSet.start();
                isBackside = true;
            }else {//当前反面
                mRightOutSet.setTarget(mFlBack);
                mLeftInSet.setTarget(mFlFront);
                mRightOutSet.start();
                mLeftInSet.start();
                isBackside = false;
            }
        }
    }
}
