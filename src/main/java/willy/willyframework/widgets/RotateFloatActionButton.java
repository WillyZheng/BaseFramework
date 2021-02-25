package willy.willyframework.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import willy.willyframework.R;

/**
 * 旋转动画的floatActionButton
 * Created by willy on 16/7/20.
 */
public class RotateFloatActionButton extends FloatingActionButton {

    //是否已经旋转过了
    private boolean isAlreadyRotate = false;
    //是否允许旋转动作,默认可以旋转
    private boolean isCanRotate = true;

    public RotateFloatActionButton(Context context) {
        this(context, null);
    }

    public RotateFloatActionButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotateFloatActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RotateFloatActionButton, defStyleAttr, 0);
        isCanRotate = array.getBoolean(R.styleable.RotateFloatActionButton_can_rotate, true);
        array.recycle();
    }

    public boolean getIfCanRotate() {
        return isCanRotate;
    }

    public void setIfCanRotate(boolean canRotate) {
        isCanRotate = canRotate;
    }

    /**
     * 点击开始的动画
     */
    protected void startAnimator() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "rotation", 0, -155, -135);
        objectAnimator.setDuration(500);
        objectAnimator.start();
        isAlreadyRotate = true;
        //蒙版
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0,0.7f);
//        alphaAnimation.setDuration(500);
//        alphaAnimation.setFillAfter(true);
    }

    /**
     * 点击关闭的动画
     */
    protected void closeAnimator() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "rotation", -135, 20, 0);
        objectAnimator.setDuration(500);
        objectAnimator.start();
        isAlreadyRotate = false;
    }

    /**
     * 设置点击的监听，直接内部实现动画
     *
     * @param listener
     */
    public void setOnRotateButtonClickListener(final RotateButtonClickListener listener) {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAlreadyRotate && isCanRotate) {
                    closeAnimator();
                } else if (isCanRotate) {
                    startAnimator();
                }
                listener.onRotateButtonClick(v, isAlreadyRotate);
            }
        });
    }

    /**
     * 动画button的点击监听回调
     */
    public interface RotateButtonClickListener {
        /**
         * @param view     旋转的view
         * @param isRotate 是否已经旋转了
         */
        void onRotateButtonClick(View view, boolean isRotate);
    }
}
