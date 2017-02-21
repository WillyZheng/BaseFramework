package willy.willyframework.base.application;

import android.app.Application;

/**
 * application的基类
 * Created by willy on 16/7/18.
 */
public class BaseApplication extends Application{
    private static BaseApplication mInstance;

    public static BaseApplication getInstance(){
        return mInstance == null ? new BaseApplication() : mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
