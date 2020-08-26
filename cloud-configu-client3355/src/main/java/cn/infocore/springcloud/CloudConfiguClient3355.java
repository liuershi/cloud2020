package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/25 22:58
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfiguClient3355 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfiguClient3355.class, args);
    }
}
