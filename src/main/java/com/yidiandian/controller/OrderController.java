package com.yidiandian.controller;

import com.alipay.api.AlipayApiException;
import com.yidiandian.alipay.AlipayBean;
import com.yidiandian.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/27 14:11
 * @Email: 15290810931@163.com
 */
@RestController
public class OrderController {

    @Autowired
    private PayService payService;

    /**
     * 阿里支付
     * @param tradeNo
     * @param subject
     * @param amount
     * @param body
     * @return
     * @throws AlipayApiException
     */
    @PostMapping(value = "order/alipay")
    public String alipay(String outTradeNo, String subject, String totalAmount, String body) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);
        return payService.aliPay(alipayBean);
    }
}
