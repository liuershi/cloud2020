package cn.infocore.springcloud;

import cn.infocore.rule.MyRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/11 15:45
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PROVIDER-SERVICE", configuration = MyRandomRule.class)
public class OrderMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderMain80.class, args);
    }
}
