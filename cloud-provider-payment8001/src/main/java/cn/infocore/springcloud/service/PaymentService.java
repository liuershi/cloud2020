package cn.infocore.springcloud.service;

import cn.infocore.springcloud.entites.Payment;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/11 13:58
 * @Description
 */
public interface PaymentService {

    public int createPayment(Payment payment);

    public Payment getPaymentById(Long id);
}
