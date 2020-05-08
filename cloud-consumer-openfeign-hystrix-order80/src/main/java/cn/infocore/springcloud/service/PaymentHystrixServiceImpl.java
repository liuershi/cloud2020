package cn.infocore.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/5/8 22:34
 * @Description
 */
@Component//加入容器管理
public class PaymentHystrixServiceImpl implements PaymentHystrixService{
    @Override
    public String getPaymentInfo_ok(Integer id) {
        return "global error execute getPaymentInfo_ok ; ID: " + id + " o(╥﹏╥)o";
    }

    @Override
    public String getPaymentInfo_timeout(Integer id) {
        return "global error execute getPaymentInfo_timeout ; ID: " + id + " o(╥﹏╥)o";
    }
}
