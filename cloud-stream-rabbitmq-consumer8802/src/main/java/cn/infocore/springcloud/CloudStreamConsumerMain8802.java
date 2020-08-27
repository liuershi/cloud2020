package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/26 15:06
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamConsumerMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamConsumerMain8802.class, args);
    }
}
