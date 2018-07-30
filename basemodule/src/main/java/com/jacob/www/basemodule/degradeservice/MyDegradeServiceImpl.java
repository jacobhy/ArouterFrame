package com.jacob.www.basemodule.degradeservice;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

import static com.jacob.www.basemodule.constant.ArouterUrlConstant.AROUTER_URL_BASEMODULE_DEGRADE_SERVICE;

/**
 * @author JacobYu
 * @classDescription:
 * @createTime 2018/7/25
 */
@Route(path = AROUTER_URL_BASEMODULE_DEGRADE_SERVICE)
public class MyDegradeServiceImpl implements DegradeService {

    private Context mContext;

    @Override
    public void onLost(Context context, Postcard postcard) {
        Log.e("MyDegradeServiceImpl", "onLost: " );
    }

    @Override
    public void init(Context context) {
        // application
        mContext = context;
        Log.e("MyDegradeServiceImpl", "context: " + context);
    }
}
