package com.hjy.materialdesignabout.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hjy.materialdesignabout.R;
import com.hjy.materialdesignabout.adapter.BaseFragmentAdapter;
import com.hjy.materialdesignabout.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : HJY
 *     time   : 2017/12/15/14:03
 *     desc   : 文件描述
 *     version: 当前版本号
 * </pre>
 */
public class ViewPagerTabLayoutActivity extends AppCompatActivity {
    private static final String TAG = "ViewPagerTabLayoutAct";
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private AppBarLayout mAppBarLayout;
    private List<Fragment> mFragments;
    private String[] mTitles = new String[]{"主页", "微博", "相册"};

    public static void start(Context context) {
        context.startActivity(new Intent(context, ViewPagerTabLayoutActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_tablayout);

        mTabLayout = findViewById(R.id.viewPager_tabs);
        mViewPager = findViewById(R.id.viewPager_vp);
        mAppBarLayout = findViewById(R.id.viewpager_appbarLayout);
        setUpViewPager();
    }

    private void setUpViewPager() {
        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            ListFragment listFragment = ListFragment.newInstance(title);
            mFragments.add(listFragment);
        }
        mViewPager.setAdapter(new BaseFragmentAdapter(getSupportFragmentManager(), mFragments, mTitles));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public void onClick(View view) {
        mAppBarLayout.setVisibility(mAppBarLayout.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
    }
}
