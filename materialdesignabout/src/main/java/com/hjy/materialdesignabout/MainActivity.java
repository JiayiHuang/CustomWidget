package com.hjy.materialdesignabout;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

import com.hjy.materialdesignabout.bottomsheet.BottomSheetActivity;
import com.hjy.materialdesignabout.ui.ToolbarUsageActivity;
import com.hjy.materialdesignabout.ui.ViewPagerTabLayoutActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getBarsHeight();

    }

    /**
     * <pre>
     * 获取状态栏StatusBar和标题栏TitleBar的高度；
     * {@link Window#getDecorView()}得到的是Window中最顶层的View。
     * {@link View#getWindowVisibleDisplayFrame(Rect)}可以获取到程序显示的区域，
     *      包括标题栏，但不包括状态栏。
     * </pre>
     */
    private void getBarsHeight() {

        final View decorView = getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                Rect rect = new Rect();
                decorView.getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = rect.top;
                View contentView = getWindow().findViewById(Window.ID_ANDROID_CONTENT);
                int contentViewTop = contentView.getTop();
                int titleBarHeight = contentViewTop - statusBarHeight;
                Log.i(TAG, "onGlobalLayout: statusBarHeight == " + statusBarHeight);
                Log.i(TAG, "onGlobalLayout: titleBarHeight == " + titleBarHeight);
            }
        });

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_toolbar_usage:
                ToolbarUsageActivity.start(this);
                break;
            case R.id.main_viewPager_tabLayout:
                ViewPagerTabLayoutActivity.start(this);
                break;
            case R.id.main_bottom_sheet:
                BottomSheetActivity.start(this);
                break;
        }
    }
}
