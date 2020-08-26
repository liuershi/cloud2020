package cn.infocore.springcloud.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/25 23:42
 * @Description
 */
@Data
@RefreshScope
@Component
public class ParametersData {

    /**
     * 通过@RefreshScope手动刷新值，需要先手动发送POST请求，例如：curl -X POST http://localhost:3355/actuator/refresh
     */
    @Value("${config.info}")
    private String configInfo;
}
