package com.jacob.www.arouterframe;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author JacobYu
 * @classDescription:
 * @createTime 2018/7/24
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        if ("debug".equals(BuildConfig.BUILD_TYPE)) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
