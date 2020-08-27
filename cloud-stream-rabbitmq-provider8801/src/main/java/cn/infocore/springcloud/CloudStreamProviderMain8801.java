package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/26 14:32
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamProviderMain8801.class, args);
    }
}
