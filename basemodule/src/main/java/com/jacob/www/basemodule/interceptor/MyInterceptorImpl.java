package com.jacob.www.basemodule.interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * @author JacobYu
 * @classDescription:
 * @createTime 2018/7/24
 */
@Interceptor(priority = 1, name = "重新分组进行拦截")
public class MyInterceptorImpl implements IInterceptor {

    private Context mContext;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        callback.onInterrupt(null);
        if (postcard.getGroup().equals("module1")) {
            postcard.withString("extra", "我是在拦截器中附加的参数");
            callback.onContinue(postcard);
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        // application
        mContext = context;
        Log.e("MyInterceptorImpl", "context: " + context);
    }
}

