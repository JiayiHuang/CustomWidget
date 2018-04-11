package com.hjy.materialdesignabout.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * <pre>
 *     author : HJY
 *     time   : 2017/12/15/17:50
 *     desc   : 文件描述
 *     version: 当前版本号
 * </pre>
 */
public class JToast {
    private static Toast mToast;

    public static void shortT(Context context, String msg) {
        toast(context, msg, Toast.LENGTH_SHORT);
    }

    public static void longT(Context context, String msg) {
        toast(context, msg, Toast.LENGTH_LONG);
    }

    private static void toast(Context context, String msg, int length) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(context, msg, length);
        mToast.show();
    }
}
