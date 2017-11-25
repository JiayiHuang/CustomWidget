package com.hjy.customwidgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hjy.customwidgets.flipcard.FlipCardAnimation;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    FlipCardAnimation animation010;
    FlipCardAnimation animation011;
    FlipCardAnimation animation02;
    FlipCardAnimation animation03;
    int num = 0;
    ImageView iv01_pro, iv02_pro, iv03_pro;

    private static final int[] DRAWABLE = {R.drawable.ic_card_giftcard_white_48dp, R.drawable.ic_card_membership_white_48dp, R.drawable.ic_markunread_white_48dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout ll01 = (LinearLayout) findViewById(R.id.ll01);
        final LinearLayout ll02 = (LinearLayout) findViewById(R.id.ll02);
        final LinearLayout ll03 = (LinearLayout) findViewById(R.id.ll03);
        final View view_bg = findViewById(R.id.view_bg);

        iv01_pro = (ImageView) findViewById(R.id.iv01_pro);
        iv02_pro = (ImageView) findViewById(R.id.iv02_pro);
        iv03_pro = (ImageView) findViewById(R.id.iv03_pro);
        final TextView tv01Content = (TextView) findViewById(R.id.tv01_content);
        final TextView tv02Content = (TextView) findViewById(R.id.tv02_content);
        final TextView tv03Content = (TextView) findViewById(R.id.tv03_content);
        final TextView tv01Price = (TextView) findViewById(R.id.tv01_price);
        final TextView tv02Price = (TextView) findViewById(R.id.tv02_price);
        final TextView tv03Price = (TextView) findViewById(R.id.tv03_price);

        ll01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(animation011, ll01, tv01Content, tv01Price, iv01_pro, 180);
                startAnimation(animation010, view_bg, null, null, null, -180);
            }
        });

        ll02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(animation02, ll02, tv02Content, tv02Price, iv02_pro, 180);
            }
        });
/*
        ll03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(animation03, ll03, tv03Content, tv03Price, iv03_pro, -180);
            }
        });
*/
        ll03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(animation03, ll03, tv03Content, tv03Price, iv03_pro, -270);
            }
        });
    }

    private void startAnimation(FlipCardAnimation animation, View rootView, final TextView tvContent,
                                final TextView tvPrince, final ImageView iv, int degree) {
        if (animation != null) {
            animation.setCanContentChange();
            rootView.startAnimation(animation);
        } else {
            int centerX = rootView.getWidth() / 2;
            int centerY = rootView.getHeight() / 2;
            animation = new FlipCardAnimation(0, degree, centerX, centerY);
            animation.setInterpolator(new AnticipateOvershootInterpolator());
            animation.setDuration(3000);
            animation.setFillAfter(false);
            animation.setRepeatCount(-1);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    ((FlipCardAnimation) animation).setCanContentChange();
                }
            });
            animation.setOnContentChangeListener(new FlipCardAnimation.OnContentChangeListener() {
                @Override
                public void onContentChange() {
                    if (iv == null) {
                        return;
                    }
                    if (num >= 3) {
                        num = 0;
                    }
                    iv.setBackgroundResource(DRAWABLE[num]);
                    tvContent.setText("￥" + new Random().nextInt(500));

                    if (num == 0) {
                        tvPrince.setText("Discount");
                    } else if (num == 1) {
                        tvPrince.setText("Price");
                    } else if (num == 2) {
                        tvPrince.setText("Cost");
                    }
                    num++;
                }
            });
            rootView.startAnimation(animation);
        }
    }
}
