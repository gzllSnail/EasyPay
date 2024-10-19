package com.xgr.easypay.demo;

import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.alipay.sdk.app.EnvUtils;
import com.xgr.alipay.AliPay;
import com.xgr.alipay.AlipayInfoImpli;
import com.xgr.easypay.EasyPay;
import com.xgr.easypay.callback.IPayCallback;
import com.xgr.unionpay.unionpay.Mode;
import com.xgr.unionpay.unionpay.UnionPay;
import com.xgr.unionpay.unionpay.UnionPayInfoImpli;
import com.xgr.wechatpay.wxpay.WXPay;
import com.xgr.wechatpay.wxpay.WXPayInfoImpli;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.unionpay).setOnClickListener(v -> unionpay());
        findViewById(R.id.wxpay).setOnClickListener(v -> wxpay());
        findViewById(R.id.alipay).setOnClickListener(v -> alipay());
    }

    /**
     * 银联提供了测试帐号：
     * 测试卡号信息：
     * 借记卡：6226090000000048
     * 手机号：18100000000
     * 密码：111101
     * 短信验证码：123456
     * （短信验证码记得点下获取验证码之后再输入）
     * 测试订单生成网址：使用 提供的 Eclipse 项目跑通得到测试的
     */
    private void unionpay() {
        //实例化银联支付策略
        UnionPay unionPay = new UnionPay();
        //构造银联订单实体。一般都是由服务端直接返回。
        UnionPayInfoImpli unionPayInfoImpli = new UnionPayInfoImpli();
        unionPayInfoImpli.setTn("填入TN");
        //测试时可以用Mode.TEST,发布时用Mode.RELEASE
        unionPayInfoImpli.setMode(Mode.TEST);
        //策略场景类调起支付方法开始支付，以及接收回调。
        EasyPay.pay(unionPay, this, unionPayInfoImpli, new IPayCallback() {
            @Override
            public void success() {
                toast("支付成功");
            }

            @Override
            public void failed(int code, String message) {
                toast("支付失败");
            }

            @Override
            public void cancel() {
                toast("支付取消");
            }
        });
    }

    private void wxpay() {
        //实例化微信支付策略
        WXPay wxPay = WXPay.getInstance();
        //构造微信订单实体。一般都是由服务端直接返回。
        WXPayInfoImpli wxPayInfoImpli = new WXPayInfoImpli();
        wxPayInfoImpli.setAppid("");
        wxPayInfoImpli.setPartnerid("");
        wxPayInfoImpli.setPrepayId("");
        wxPayInfoImpli.setPackageValue("Sign=WXPay");
        wxPayInfoImpli.setNonceStr("");
        wxPayInfoImpli.setTimestamp("");
        wxPayInfoImpli.setSign("");
        //策略场景类调起支付方法开始支付，以及接收回调。
        EasyPay.pay(wxPay, this, wxPayInfoImpli, new IPayCallback() {
            @Override
            public void success() {
                toast("支付成功");
            }

            @Override
            public void failed(int code, String message) {
                toast("支付失败");
            }

            @Override
            public void cancel() {
                toast("支付取消");
            }
        });
    }

    private void alipay() {
        //实例化支付宝支付策略
        AliPay aliPay = new AliPay();
        //构造支付宝订单实体。一般都是由服务端直接返回。
        AlipayInfoImpli alipayInfoImpli = new AlipayInfoImpli();
        //"alipay_sdk=alipay-sdk-java-4.39.234.ALL&app_id=9021000122694544&biz_content=%7B%22out_trade_no%22%3A%2270501111111S001111117%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%A4%A7%E4%B9%90%E9%80%8F%22%2C%22total_amount%22%3A%229.00%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&sign=Qg%2FOYJwV%2BILxPzYRBtsWAa8iSFDSp76Mud6R1mpnFbC2u1%2F0M8HK%2FtqhY%2B%2FK9WZIE1Gmye2MQruoCpd%2FInbl%2BBOFeNE64YrOfxzwbS4RDfhvCuN1xD%2Fp%2ByvRAqebrHqd1Hl0Kah%2FhIoGaBYd7AhVMFOQOBYnf%2FFdUsHqgQExhZMg1vYkWTXkQvdNNZ1SKrb7oX0fVljPP%2BZihFAJhoPsmjlDg3RvUjCeRlpFIDlIBm4MnO8VPYxFWEx%2FlcCk26o1dZ1jQ5JJBoGCGLhfPC9srHQsW77Ak%2Brmv9nhy0TOvX6dA%2F5w4sqr7Ns9l3sZVc5zGJEKykVMiSw1HSAW4gx30w%3D%3D&sign_type=RSA2&timestamp=2024-10-18+12%3A12%3A47&version=1.0"
        alipayInfoImpli.setOrderInfo("上面注释的是例子");
        //测试时可以用EnvUtils.EnvEnum.SANDBOX,发布时用EnvUtils.EnvEnum.ONLINE
        alipayInfoImpli.setEnvEnum(EnvUtils.EnvEnum.SANDBOX);
        //策略场景类调起支付方法开始支付，以及接收回调。
        EasyPay.pay(aliPay, this, alipayInfoImpli, new IPayCallback() {
            @Override
            public void success() {
                toast("支付成功");
            }

            @Override
            public void failed(int code, String message) {
                toast("支付失败" + code + message);
            }

            @Override
            public void cancel() {
                toast("支付取消");
            }
        });
    }

    private void toast(String context) {
        Toast.makeText(this, context, Toast.LENGTH_LONG).show();
    }
}
