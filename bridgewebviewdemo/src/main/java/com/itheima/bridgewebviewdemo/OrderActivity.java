package com.itheima.bridgewebviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.itheima.view.BridgeWebView;

import org.w3c.dom.Text;

/**
 * 模块名称:
 * Created by fly(zhoufeng) on 2017/7/24.
 */

public class OrderActivity extends AppCompatActivity {

    private BridgeWebView mWeview;
    private Button mtextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setWebViewClient();
    }

    private void initView() {
        mWeview = (BridgeWebView) findViewById(R.id.weview);
        mWeview.addBridgeInterface(new JavaSctiptMethods(OrderActivity.this, mWeview));//设置js和android通信桥梁方法
        mWeview.loadUrl("file:///android_asset/BridgeWebView/orderDetail.html");//本地模板


        mtextview = (Button) this.findViewById(R.id.mytextview);
        mtextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OrderActivity.this,"点击跳过",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setWebViewClient() {
        mWeview.setWebViewClient(new WebViewClient());

        mWeview.setWebChromeClient(new WebChromeClient());
    }
}
