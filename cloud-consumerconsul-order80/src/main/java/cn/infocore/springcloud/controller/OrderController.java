package cn.infocore.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/16 10:05
 * @Description
 */
@RestController
public class OrderController {

    private static final String ORDER_CONSUL_URL = "http://cloud-providerconsul-service/cloud-providerconsul-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/order/consul")
    public String orderConsul() {
        return restTemplate.getForObject(ORDER_CONSUL_URL + "/payment/consul", String.class);
    }
}
