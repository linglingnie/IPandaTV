package com.pandatv.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.multidex.MultiDexApplication;

import com.pandatv.manager.ActivityCollector;


/**
 * Created by chj on 2017/8/20.
 * 方案两种一种使用配置文件设置连个app
 * 一种吧mod里面的代码给copy过来
 *
 */

public class BaseApplication extends MultiDexApplication {
    public static class Config{
        public static final boolean DEVELOPER_MORE=false;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        if (Config.DEVELOPER_MORE&& Build.VERSION.SDK_INT<=Build.VERSION_CODES.GINGERBREAD) {
            //设置线程的严苛模式
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyDialog().build());
            //设置虚拟机的严苛模式
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyDeath().build());
        }
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.ICE_CREAM_SANDWICH){
            registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

                }

                @Override
                public void onActivityStarted(Activity activity) {

                }

                @Override
                public void onActivityResumed(Activity activity) {
                    //设置Activity的栈管理
                    ActivityCollector.getInstance().setCurrentActivity(activity);
                }

                @Override
                public void onActivityPaused(Activity activity) {

                }

                @Override
                public void onActivityStopped(Activity activity) {

                }

                @Override
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

                }

                @Override
                public void onActivityDestroyed(Activity activity) {

                }
            });
        }

    }

    //当内存低时发送广播可以释放一些内存
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
    //退出整个应用
    public void exit(){
        ActivityCollector.getInstance().exit(this);
    }
}
