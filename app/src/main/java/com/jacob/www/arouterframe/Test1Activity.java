package com.jacob.www.arouterframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jacob.www.arouterframe.bean.TestBeanImplParcel;
import com.jacob.www.arouterframe.bean.TestBean;

import static com.jacob.www.basemodule.constant.ArouterUrlConstant.AROUTER_URL_APP_TEST1;

@Route(path = AROUTER_URL_APP_TEST1)
public class Test1Activity extends AppCompatActivity {

    @Autowired(name = "bean1")
    TestBean bean1;

    @Autowired(name = "bean2")
    TestBeanImplParcel bean2;

    @Autowired
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ARouter.getInstance().inject(this);
        Log.e("Test1Activity", "onCreate: " + (bean1 == null ? "null" : bean1.data));
        Log.e("Test1Activity", "onCreate: " + (bean2 == null ? "null" : bean2.data));
        bundle = getIntent().getExtras();
        Log.e("Test1Activity", "onCreate: " + (bundle == null ? "null" : bundle.getString("bundle")));
        Log.e("Test1Activity", "onCreate: " + (bundle == null ? "null" : bundle.getParcelable("bean2")));
    }
}
