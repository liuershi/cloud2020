package cn.infocore.springcloud.service.impl;

import cn.infocore.springcloud.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/26 14:34
 * @Description
 */
@EnableBinding(Source.class)
@Slf4j
public class IMessageServiceImpl implements IMessageService {

    @Resource
    private MessageChannel output;

    @Override
    public String sendMessage() {
        String uuid = UUID.randomUUID().toString();
        log.info("send message : {}", uuid);
        output.send(MessageBuilder.withPayload(uuid).build());
        return null;
    }
}
