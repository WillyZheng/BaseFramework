package willy.willyframework.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * 一些提示的工具类
 * Created by willy on 16/7/19.
 */
public class HintUtil {
    /**
     * 弹出snackbar提示
     * @param view  依附的view
     * @param msg   弹出的信息
     */
    public static void showSnack(View view,String msg){
        Snackbar.make(view,msg,Snackbar.LENGTH_SHORT).show();
    }
}
