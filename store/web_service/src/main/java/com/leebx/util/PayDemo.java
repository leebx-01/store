package com.leebx.util;

import com.github.wxpay.sdk.WXPay;
import com.leebx.pojo.Order_web;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class PayDemo {
    //付款生成url
    public  String testPay(Order_web order){
        WXPay wxPay = new WXPay(new PayConfig());
        try {
            Map<String, String> data = new HashMap<String,String>();
            // 商品描述
            data.put("body", "西安粤嵌测试");
            // 订单号
            data.put("out_trade_no", order.getOrderId()+"");
            //货币
            data.put("fee_type", "CNY");
            //金额，单位是分
            data.put("total_fee", "1");
            //调用微信支付的终端IP（estore商城的IP）
            data.put("spbill_create_ip", "127.0.0.1");
            //回调地址
            data.put("notify_url", "http://test.yq.com/wxpay/notify");
            // 交易类型为扫码支付
            data.put("trade_type", "NATIVE");
            //商品id,使用假数据
            data.put("product_id", "1234567");

            Map<String, String> result = wxPay.unifiedOrder(data);
//            System.out.println("--------------------------------------------");
            if ("SUCCESS".equals(result.get("return_code"))) {
                String url = result.get("code_url");
                return url;
            } else {
//                System.out.println("创建预交易订单失败，错误信息");
                return null;
            }
        } catch (Exception e) {
//            System.out.println("创建预交易订单异常");
            e.printStackTrace();
            return null;
        }
    }
    //查询是否付款成功
    public String queryPay(String oid){
        WXPay wxPay = new WXPay(new PayConfig());
        Map<String, String> data = new HashMap<>();
        // 订单号
        data.put("out_trade_no", oid);
        try {
            Map<String, String> result = wxPay.orderQuery(data);
            if (result == null) {
//                System.out.println("未查询到结果，未付款！");
                return "1";
            }
            String state = result.get("trade_state");
            if ("SUCCESS".equals(state)) {
                // success，则认为付款成功
//                System.out.println("付款成功！");
                return "2";
                // 修改订单状态为已付款
            }else {
                //USERPAYING,NOTPAY
//                System.out.println("未付款或正在付款，都认为是未付款");
                return "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }
}
