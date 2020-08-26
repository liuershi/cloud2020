package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/26 10:29
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfiguClient3366 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfiguClient3366.class, args);
    }
}
