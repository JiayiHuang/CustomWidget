package com.hjy.customwidgets.flipcard;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * <pre>
 *     author : HJY
 *     time   : 2017/11/25/10:51
 *     desc   : 文件描述
 *     version: 当前版本号
 * </pre>
 */
public class FlipCardAnimation extends Animation {
    private final float mFromDegrees, mToDegrees, mCenterX, mCenterY;
    private Camera mCamera;
    private boolean isContentChange;
    private OnContentChangeListener mListener;

    public FlipCardAnimation(float fromDegrees, float toDegrees, float centerX, float centerY) {
        this.mFromDegrees = fromDegrees;
        this.mToDegrees = toDegrees;
        this.mCenterX = centerX;
        this.mCenterY = centerY;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float degrees = mFromDegrees + ((mToDegrees - mFromDegrees) * interpolatedTime);
        Matrix matrix = t.getMatrix();
        mCamera.save();
        if (degrees > 90 || degrees < -90) {
            if (!isContentChange) {
                if (mListener != null) {
                    mListener.onContentChange();
                }
                isContentChange = true;
            }
            if (degrees > 0) {
                degrees = 270 + degrees - 90;
            } else if (degrees < 0) {
                degrees = -270 + (degrees + 90);
            }
        }
        mCamera.rotateX(degrees);
        mCamera.getMatrix(matrix);
        mCamera.restore();
        matrix.preTranslate(-mCenterX, -mCenterY);
        matrix.postTranslate(mCenterX, mCenterY);
    }

    public void setCanContentChange() {
        this.isContentChange = false;
    }

    public interface OnContentChangeListener {
        void onContentChange();
    }

    public void setOnContentChangeListener(OnContentChangeListener listener) {
        this.mListener = listener;
    }
}
