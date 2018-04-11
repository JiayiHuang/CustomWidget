package com.hjy.materialdesignabout.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.hjy.materialdesignabout.R;
import com.hjy.materialdesignabout.adapter.SimpleListAdapter;

import java.util.ArrayList;

/**
 * <pre>
 *     author : HJY
 *     time   : 2017/12/15/14:07
 *     desc   : 文件描述
 *     version: 当前版本号
 * </pre>
 */
public class ListFragment extends BaseFragment{
    private static final String KEY = "KEY_ARGS";
    private RecyclerView mRecycler;
    private SwipeRefreshLayout mSwipe;

    public static ListFragment newInstance(String title) {
        ListFragment fragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    private String title;
    private ArrayList<String> mDatas = new ArrayList<>();
    @Override
    protected void initView(View rootView) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            title = arguments.getString(KEY);
        }
        mRecycler = rootView.findViewById(R.id.fragment_recyclerSwipe_recyclerView);
        mSwipe = rootView.findViewById(R.id.fragment_recyclerSwipe_swipe);
        mSwipe.setEnabled(false);

        mRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        mRecycler.addItemDecoration(new DividerItemDecoration(mContext, LinearLayout.VERTICAL));

        for (int i = 0; i < 50; i++) {
            String s = String.format("我是第 %d 个" + title, i);
            mDatas.add(s);
        }
        SimpleListAdapter mAdapter = new SimpleListAdapter(mDatas);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list_swipe;
    }

    @Override
    public void fetchData() {

    }
}
