package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/28 23:22
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudSentinelServiceMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(CloudSentinelServiceMain8401.class, args);
    }
}
