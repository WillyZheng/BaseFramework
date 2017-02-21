package willy.willyframework.utils;

import willy.willyframework.base.application.BaseApplication;

/**
 * app应用内资源获取工具类
 * Created by willy on 16/7/19.
 */
public class ResourceUtil {

    /**
     * 获取字符资源
     * @param resId 字符资源的id
     * @return      字符串
     */
    public static String getResourceString(int resId){
        return BaseApplication.getInstance().getResources().getString(resId);
    }
}
