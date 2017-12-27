package main.zzy.com.hotel;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by Administrator on 2017/12/20.
 */

public class HotelApp extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base); MultiDex.install(this);
    }
}
