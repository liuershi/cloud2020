package cn.infocore.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/15 15:34
 * @Description
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    @LoadBalanced // 轮询调用多个不同服务
        public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}