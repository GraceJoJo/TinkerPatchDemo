package com.jojo.tinkerpatchdemo;

import android.app.Application;

import com.tencent.tinker.loader.app.ApplicationLike;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;

/**
 * Created by JoJo on 2018/5/26.
 * wechat：18510829974
 * description：
 */
public class MyApplication extends Application {

    private ApplicationLike tinkerApplicationLike;
    private ApplicationLike tinkerAppLike;


//    @Override
//    public void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        //you must install multiDex whatever tinker is installed!
//        MultiDex.install(base);
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        initTinkerPatch();

    }

    private void initTinkerPatch() {
//        // 我们可以从这里获得Tinker加载过程的信息
//        if (BuildConfig.TINKER_ENABLE) {
//            tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();
//            // 初始化TinkerPatch SDK, 更多配置可参照API章节中的,初始化SDK
//            TinkerPatch.init(tinkerApplicationLike)
//                    .reflectPatchLibrary()
//                    .setPatchRollbackOnScreenOff(true)
//                    .setPatchRestartOnSrceenOff(true)
//                    .setFetchPatchIntervalByHours(1);
//
//            // 每隔1个小时(通过setFetchPatchIntervalByHours设置)去访问后台时候有更新,通过handler实现轮训的效果
//        TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();
//        }
        if (BuildConfig.TINKER_ENABLE){
            tinkerAppLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();
            TinkerPatch.init(tinkerAppLike)
                    //是否自动反射Library路径,无须手动加载补丁中的So文件
                    //注意,调用在反射接口之后才能生效,你也可以使用Tinker的方式加载Library
                    .reflectPatchLibrary()
                    //设置收到后台回退要求时,锁屏清除补丁
                    //默认是等主进程重启时自动清除
                    .setPatchRollbackOnScreenOff(true)
                    //设置补丁合成成功后,锁屏重启程序
                    //默认是等应用自然重启
                    .setPatchRestartOnSrceenOff(true);

        }
        // 每隔一小时检查一次，按自己需求设定
//        new FetchPatchHandler().fetchPatchWithInterval(1);
    }
}
