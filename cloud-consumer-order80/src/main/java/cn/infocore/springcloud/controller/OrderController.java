package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.entites.CommonResult;
import cn.infocore.springcloud.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/11 15:46
 * @Description
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_PROVIDER_URL = "http://localhost:8001/cloud-provider-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        // 注意，返回的CommonResult必须要有无参构造，否则getForObject()方法会抛出异常
        return restTemplate.getForObject(PAYMENT_PROVIDER_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/payment/create")
    public CommonResult createPayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_PROVIDER_URL + "/payment/create", payment, CommonResult.class);
    }
}
