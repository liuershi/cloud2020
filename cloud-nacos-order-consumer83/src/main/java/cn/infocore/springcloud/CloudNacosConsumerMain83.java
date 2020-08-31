package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/27 10:17
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConsumerMain83.class, args);
    }
}
