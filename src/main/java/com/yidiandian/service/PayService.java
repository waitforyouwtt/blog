package com.yidiandian.service;

import com.alipay.api.AlipayApiException;
import com.yidiandian.alipay.AlipayBean;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/12/27 14:12
 * @Email: 15290810931@163.com
 */
public interface PayService {

    /**
     * 支付宝支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;

}
