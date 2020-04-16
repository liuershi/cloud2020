package cn.infocore.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/15 15:33
 * @Description
 */
@RestController
public class OrderZKController {

    private static final String PAYMENT_URL = "http://cloud-provider-service/cloud-provider-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/payment/getPaymentZk")
    public String getPaymentZk() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/registerZoo", String.class);
    }
}
