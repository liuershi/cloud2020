package cn.infocore.springcloud.service;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/5/8 10:12
 * @Description
 */
public interface PaymentService {
    public String getPaymentInfo_ok(Integer id);

    public String getPaymentInfo_timeout(Integer id);

    public String paymentInfo_timeoutHandler(Integer id);
}
