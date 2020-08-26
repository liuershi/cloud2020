package cn.infocore.springcloud.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/26 10:30
 * @Description
 */
@Data
@Component
@RefreshScope
public class CommonData {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;
}
