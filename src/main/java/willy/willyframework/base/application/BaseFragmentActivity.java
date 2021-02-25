package willy.willyframework.base.application;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import willy.willyframework.utils.ViewUtil;

/**
 * fragmentActivity的基类
 * Created by willy on 16/7/18.
 */
public abstract class BaseFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (setImmersiveStatusBar()) {
            ViewUtil.setImmersiveStatusBar(this);
        }
        setContentView(getActivityContentView());
        getSupportFragmentManager().beginTransaction().add(getFragmentActivityLayoutId(), getJumpFragment(), getJumpFragmentTag()).commitAllowingStateLoss();
    }

    /**
     * 是否设置沉浸式的透明状态栏
     *
     * @return true 设置 false 不设置
     */
    protected abstract boolean setImmersiveStatusBar();

    /**
     * 获取当前activity的contentview
     *
     * @return 当前contentview的id
     */
    protected abstract int getActivityContentView();

    /**
     * 获取要跳转的fragment的tag
     *
     * @return 要跳转的fragment的tag
     */
    protected abstract String getJumpFragmentTag();

    /**
     * 获取要跳转的fragment
     *
     * @return 要跳转的fragment
     */
    protected abstract Fragment getJumpFragment();

    /**
     * 获取该activity要替换的layout的id
     *
     * @return 替换的view的layout id
     */
    protected abstract int getFragmentActivityLayoutId();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        FragmentMrg.toBackFragment(this,getJumpFragment());
    }
}
