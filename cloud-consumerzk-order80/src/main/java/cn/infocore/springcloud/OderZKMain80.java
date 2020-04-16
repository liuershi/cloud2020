package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/15 15:32
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OderZKMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OderZKMain80.class, args);
    }
}
