package com.hjy.materialdesignabout.bottomsheet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hjy.materialdesignabout.R;

/**
 * <pre>
 *     author : HJY
 *     time   : 2017/12/15/16:06
 *     desc   : 文件描述
 *     version: 当前版本号
 * </pre>
 */
public class BottomSheetActivity extends AppCompatActivity {
    private static final String TAG = "BottomSheetActivity";

    public static void start(Context context) {
        context.startActivity(new Intent(context, BottomSheetActivity.class));
    }

    private NestedScrollView mNestScrollView;
    private BottomSheetBehavior<NestedScrollView> mBottomSheetBehavior;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        mNestScrollView = findViewById(R.id.bottomSheet_nestScrollView);
        mBottomSheetBehavior = BottomSheetBehavior.from(mNestScrollView);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bottomSheet_btn1:
            case R.id.bottomSheet_bs_tv:
                if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                break;
            case R.id.bottomSheet_btn2:
                BottomSheetDialog dialog = new BottomSheetDialog(this);
                dialog.setContentView(R.layout.dialog_bottom_sheet);
                dialog.show();
                break;
            case R.id.bottomSheet_btn3:
                CustomBottomSheetDialogFragment fragment = CustomBottomSheetDialogFragment.newInstance();
                fragment.show(getSupportFragmentManager(),"Dialog");
                break;
        }
    }
}
