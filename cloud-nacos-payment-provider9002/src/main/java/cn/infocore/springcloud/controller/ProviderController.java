package cn.infocore.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/27 10:07
 * @Description
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/provider/{id}")
    public String provider(@PathVariable("id") Long id){
        return new StringBuilder("register nacos success, server port : ").append(serverPort).append(" serial : ").append(id).toString();
    }
}
