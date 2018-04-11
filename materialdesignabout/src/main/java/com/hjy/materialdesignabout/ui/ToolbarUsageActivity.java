package com.hjy.materialdesignabout.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hjy.materialdesignabout.R;
import com.hjy.materialdesignabout.adapter.SimpleListAdapter;

import java.util.ArrayList;

/**
 * <pre>
 *     author : HJY
 *     time   : 2017/12/15/10:59
 *     desc   : Toolbar的使用
 *     version: 当前版本号
 * </pre>
 */
public class ToolbarUsageActivity extends AppCompatActivity {

    private static final String TAG = "ToolbarUsageActivity";

    public static void start(Context context) {
        Intent intent = new Intent(context, ToolbarUsageActivity.class);
        context.startActivity(intent);
    }

    private RecyclerView mRecycler;
    private RelativeLayout mRLBottomSheet;
    private Toolbar mToolbar;
    private BottomSheetBehavior<RelativeLayout> mFrom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        mRecycler = findViewById(R.id.toolbar_recycler);
        mRLBottomSheet = findViewById(R.id.toolbar_bottom_sheet);
        mFrom = BottomSheetBehavior.from(mRLBottomSheet);


        mToolbar = findViewById(R.id.toolbar_toolbar);
        // 该属性必须在setSupportActionBar之前调用
        mToolbar.setTitle("Toolbar Usage");
        // 需要配合 Application 或此 Activity 使用 NoActionBar 主题
        setSupportActionBar(mToolbar);

        initListener();
        initData();
    }

    private ArrayList<String> mDatas;

    private void initData() {
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        mDatas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mDatas.add(String.format("我是第 %d 个item", i + 1));
        }
        mRecycler.setAdapter(new SimpleListAdapter(mDatas));

    }

    private void initListener() {
        mFrom.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.i(TAG, "BottomSheet onStateChanged: newState == " + newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.i(TAG, "BottomSheet onSlide: slideOffset == " + slideOffset);
            }
        });
//        mFrom.
        mRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
