package com.hjy.materialdesignabout.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hjy.materialdesignabout.R;

import java.util.List;

/**
 * <pre>
 *     author : HJY
 *     time   : 2017/12/15/11:41
 *     desc   : 文件描述
 *     version: 当前版本号
 * </pre>
 */
public class SimpleListAdapter extends BaseQuickAdapter <String,SimpleListAdapter.SimpleHolder>{
    public SimpleListAdapter(@Nullable List<String> data) {
        super(R.layout.item_simple,data);
    }

    @Override
    protected void convert(SimpleHolder helper, String item) {
        helper.mTv.setText(item);
    }

    class SimpleHolder extends BaseViewHolder{
        TextView mTv;
        public SimpleHolder(View view) {
            super(view);
            mTv = view.findViewById(R.id.item_simple_tv);
        }
    }
}
