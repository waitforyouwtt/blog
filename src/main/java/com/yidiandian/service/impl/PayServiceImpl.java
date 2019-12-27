package com.yidiandian.service.impl;

import com.alipay.api.AlipayApiException;
import com.yidiandian.alipay.Alipay;
import com.yidiandian.alipay.AlipayBean;
import com.yidiandian.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/27 14:13
 * @Email: 15290810931@163.com
 */
@Slf4j
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private Alipay alipay;

    /**
     * 支付宝支付接口
     *
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}
