package cn.infocore.rule;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/22 22:44
 * @Description 随机规则
 */
@Configuration
public class MyRandomRule {

    @Bean
    public RandomRule getRandomRule(){
        return new RandomRule();
    }
}
