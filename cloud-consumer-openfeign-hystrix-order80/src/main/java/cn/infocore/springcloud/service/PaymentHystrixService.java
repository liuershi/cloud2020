package cn.infocore.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/5/8 11:02
 * @Description
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-SERVICE" + "/cloud-provider-hystrix-service")
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String getPaymentInfo_ok(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String getPaymentInfo_timeout(@PathVariable("id") Integer id);
}
