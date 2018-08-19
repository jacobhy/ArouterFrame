package com.jacob.www.arouterframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jacob.www.arouterframe.bean.TestBean;
import com.jacob.www.arouterframe.bean.TestBeanImplParcel;

import static com.jacob.www.basemodule.constant.ArouterUrlConstant.AROUTER_URL_APP_TEST1;
import static com.jacob.www.basemodule.constant.ArouterUrlConstant.AROUTER_URL_MODULE1_MODULE1ACTIVITY;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewTest1 = findViewById(R.id.tv_test1);
        View viewTest2 = findViewById(R.id.tv_test2);
        // module内跳转
        viewTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestBean bean1 = new TestBean("传递的数据1");
                TestBeanImplParcel bean2 = new TestBeanImplParcel("传递的数据2");
                Bundle bundle = new Bundle();
                bundle.putParcelable("bean2",bean2);
                bundle.putString("bundle","bundle");
                ARouter.getInstance()
                        .build(AROUTER_URL_APP_TEST1)
                        .with(bundle)// bundle放在最前面，放在后面会将其他传值覆盖
                        .withObject("bean1",bean1)
                        .withParcelable("bean2",bean2)
                        .navigation();
            }
        });
        // 跨module内跳转
        viewTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(AROUTER_URL_MODULE1_MODULE1ACTIVITY).navigation();
                // 重新命名分组
//                ARouter.getInstance().build(AROUTER_URL_MODULE1_MODULE1ACTIVITY,"module2").navigation();
            }
        });
    }
}
