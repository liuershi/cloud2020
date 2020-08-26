package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.common.CommonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/26 10:29
 * @Description
 */
@RestController
public class ConfigController {

    @Autowired
    private CommonData data;

    @GetMapping(value = "/getConfigInfo")
    private String getConfigInfo() {
        return new StringBuilder("server port : ").append(data.getServerPort()).append(";  ").append("config info : ").append(data.getConfigInfo()).toString();
    }
}
