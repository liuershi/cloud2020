package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/25 11:15
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudGatewayMain9528 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayMain9528.class, args);
    }
}
