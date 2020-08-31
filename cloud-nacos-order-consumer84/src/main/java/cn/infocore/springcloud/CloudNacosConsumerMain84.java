package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/30 19:28
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(/*basePackages = {"cn.infocore.springcloud.feignservice"}*/)
public class CloudNacosConsumerMain84 {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConsumerMain84.class, args);
    }
}
