package cn.infocore.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/27 10:18
 * @Description
 */
@Configuration
public class RibbonConfig {

    /**
     * 多服务时，需要开启@LoadBalanced注解，否则抛出UnknownHostException异常，消费者无法找到对应的服务
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
