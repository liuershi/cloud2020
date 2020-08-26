package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/25 16:11
 * @Description
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfiguMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfiguMain3344.class, args);
    }
}
