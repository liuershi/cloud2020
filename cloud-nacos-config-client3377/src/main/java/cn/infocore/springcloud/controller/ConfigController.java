package cn.infocore.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/27 10:57
 * @Description
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/nacos/config/getInfo")
    public String getConfig() {
        return configInfo;
    }
}
