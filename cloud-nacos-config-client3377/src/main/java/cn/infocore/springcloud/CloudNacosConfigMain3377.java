package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/27 10:57
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosConfigMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConfigMain3377.class, args);
    }
}
