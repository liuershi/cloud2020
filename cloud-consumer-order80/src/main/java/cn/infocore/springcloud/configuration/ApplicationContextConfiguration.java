package cn.infocore.springcloud.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/11 15:47
 * @Description
 */
@Configuration
public class ApplicationContextConfiguration {

    @Bean
    @LoadBalanced // 集群时使用该注解开始负载均衡算法，根据算法计算调用哪个服务提供者
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
