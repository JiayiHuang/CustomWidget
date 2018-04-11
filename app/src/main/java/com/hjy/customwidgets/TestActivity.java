package com.hjy.customwidgets;

import android.graphics.Matrix;
import android.util.Log;

/**
 * <pre>
 *     author : HJY
 *     time   : 2017/11/27/09:49
 *     desc   : 文件描述
 *     version: 当前版本号
 * </pre>
 */
public class TestActivity {
    private static final String TAG = "TestActivity";

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        float[] values = {
                1, 0, 1,
                0, 1, 1,
                0, 0, 1};
        matrix.setValues(values);
        matrix.preTranslate(2, 2);
        String toString = matrix.toString();
        Log.i(TAG, "preResult == " + toString);

    }
}
class DataItem{
    private int iData;

    public DataItem(int iData) {
        this.iData = iData;
    }

    public int getKey() {
        return iData;
    }
}
class HashTable{
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        this.arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }
    public void displayTable(){
        System.out.print("Table:");

    }
}