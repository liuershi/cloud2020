package cn.infocore.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/27 10:18
 * @Description
 */
@RestController
public class OrderConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/payment/provider/{id}")
    public String getOrder(@PathVariable("id") Long id){
        return restTemplate.getForObject(new StringBuilder(serverURL).append("/payment/provider/").append(id).toString(), String.class);
    }
}
