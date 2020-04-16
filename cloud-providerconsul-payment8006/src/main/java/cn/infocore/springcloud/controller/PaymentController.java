package cn.infocore.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/16 10:02
 * @Description
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "register consul with : " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
