package cn.infocore.springcloud.bl;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/5/6 15:17
 * @Description
 */
public interface LoadBalance {

    ServiceInstance getServiceInstance(List<ServiceInstance> instances);
}
