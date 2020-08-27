package cn.infocore.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/26 15:06
 * @Description
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    private void receiveMessage(Message<String> message) {
        log.info("server port : " + serverPort + "\t" + "receive message : " + message.getPayload());
    }
}
