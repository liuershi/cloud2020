package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.service.IMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/26 14:41
 * @Description
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageService service;

    @GetMapping(value = "/sendMessage")
    private String sendMessage(){
        return service.sendMessage();
    }
}
