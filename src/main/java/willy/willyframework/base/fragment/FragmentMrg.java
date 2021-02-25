package willy.willyframework.base.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

/**
 * fragment的管理类
 * Created by willy on 16/7/18.
 */
public class FragmentMrg {

    /**
     * 跳转到指定的fragment
     *
     * @param activity activity
     * @param fragment 要跳转到的fragment
     * @param layoutId 用于替换的布局id
     */
    public static void toFragment(FragmentActivity activity, Fragment fragment, int layoutId) {
//        activity.getSupportFragmentManager().beginTransaction().add(layoutId,fragment,fragment.getClass().getSimpleName())
//                .addToBackStack(fragment.getClass().getSimpleName())
//                .commitAllowingStateLoss();
        toFragment(activity, fragment, layoutId, false);
    }

    /**
     * 跳转到指定的fragment
     *
     * @param activity   activity
     * @param fragment   要跳转到的fragment
     * @param layoutId   用户替换的布局id
     * @param isAddStack 是否要添加该fragment到回退栈
     */
    public static void toFragment(FragmentActivity activity, Fragment fragment, int layoutId, boolean isAddStack) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.add(layoutId, fragment, fragment.getClass().getName());
        if (isAddStack) {
            ft.addToBackStack(fragment.getClass().getName());
        }
        ft.commitAllowingStateLoss();

    }

    /**
     * 移除指定的fragment
     *
     * @param activity activity
     * @param fragment 需要移除的fragment
     */
    public static void toBackFragment(FragmentActivity activity, Fragment fragment) {
        activity.getSupportFragmentManager().popBackStack();
    }
}
