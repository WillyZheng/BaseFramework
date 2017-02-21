package willy.willyframework.utils;

import android.util.Log;

/**
 * 自定义日志输出类
 * Created by willy on 16/7/18.
 * test
 */
public class LogUtil {
    private static boolean DEBUG = false;
    private static String TAG = "willy";

    public static void setDebugStatus(boolean debug){
        DEBUG = debug;
    }

    public static void setTag(String tag){
        TAG = tag;
    }


    public static void d(String msg){
        if (DEBUG){
            Log.d(TAG,msg);
        }
    }

    public static void i(String msg){
        if (DEBUG){
            Log.i(TAG, msg);
        }
    }

    public static void w(String msg){
        if (DEBUG){
            Log.w(TAG,msg);
        }
    }

    public static void e(String msg){
        if (DEBUG){
            Log.e(TAG, msg);
        }
    }
}
