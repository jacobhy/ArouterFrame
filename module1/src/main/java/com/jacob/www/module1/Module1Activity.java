package com.jacob.www.module1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import static com.jacob.www.basemodule.constant.ArouterUrlConstant.AROUTER_URL_MODULE1_MODULE1ACTIVITY;

//@Route(path = AROUTER_URL_MODULE1_MODULE1ACTIVITY, group = "module2")// 重新命名分组
@Route(path = AROUTER_URL_MODULE1_MODULE1ACTIVITY, extras = 2)// 添加额外信息
public class Module1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module1_activity_main);
        String extra = getIntent().getStringExtra("extra");
        Toast.makeText(this, extra, Toast.LENGTH_SHORT).show();
    }
}
