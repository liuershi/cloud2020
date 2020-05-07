package cn.infocore.springcloud.configu;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/5/7 22:59
 * @Description
 */
@Configuration
public class LoggerConfiguration {

    @Bean
    Logger.Level getOpenfeignLogger() {
        return Logger.Level.FULL;
    }
}
