package cn.infocore.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 11:01
 * @Description
 */
@Configuration
@MapperScan({"cn.infocore.springcloud.dao"})
public class MybatisConfiguration {
}
