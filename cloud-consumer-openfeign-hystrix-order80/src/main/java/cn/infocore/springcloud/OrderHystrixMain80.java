package cn.infocore.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/5/8 11:01
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient // 注册到eureka注册中心
@EnableFeignClients // 开启openfeign支持
@EnableHystrix      // 开始客户端hystrix服务
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}
