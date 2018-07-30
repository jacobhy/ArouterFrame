package com.jacob.www.basemodule.jsonservice;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

import static com.jacob.www.basemodule.constant.ArouterUrlConstant.AROUTER_URL_BASEMODULE_JSON;

/**
 * @author JacobYu
 * @classDescription:
 * @createTime 2018/7/25
 */
@Route(path = AROUTER_URL_BASEMODULE_JSON)
public class JsonServiceImpl implements SerializationService {

    private Context mContext;

    @Override
    public void init(Context context) {
        // application
        mContext = context;
        Log.e("JsonServiceImpl", "context: " + context);
    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        return new Gson().fromJson(text,clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return new Gson().toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return new Gson().fromJson(input,clazz);
    }
}

