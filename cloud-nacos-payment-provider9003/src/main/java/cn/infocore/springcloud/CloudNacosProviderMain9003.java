package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/30 19:41
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosProviderMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosProviderMain9003.class, args);
    }
}
