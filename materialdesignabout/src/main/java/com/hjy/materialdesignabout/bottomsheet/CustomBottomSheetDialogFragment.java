package com.hjy.materialdesignabout.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.hjy.materialdesignabout.R;

/**
 * <pre>
 *     author : HJY
 *     time   : 2017/12/15/16:23
 *     desc   : 文件描述
 *     version: 当前版本号
 * </pre>
 */
public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private BottomSheetBehavior<View> mBehavior;

    public static CustomBottomSheetDialogFragment newInstance() {
        CustomBottomSheetDialogFragment fragment = new CustomBottomSheetDialogFragment();
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        View rootDialog = /*getLayoutInflater()*/LayoutInflater.from(getContext()).inflate(R.layout.dialog_bottom_sheet, null);
//        View rootDialog = View.inflate(getContext(),R.layout.dialog_bottom_sheet, null);
        dialog.setContentView(rootDialog);
        mBehavior = BottomSheetBehavior.from((View)rootDialog.getParent());
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }
}
