package cn.infocore.springcloud.bl;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/5/6 15:18
 * @Description
 */
@Component
public class LoadBalanceImpl implements LoadBalance {
    // 原子变量，代表访问的次数
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            // 2147483647是Integer类型的最大值
            next = current >= 2147483647 ? 0 : current+1;
        } while (!atomicInteger.compareAndSet(current, next));//CAS，即比较并交换，交换成功则跳出循环
        return next;
    }

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> instances) {
        int index = getAndIncrement() % instances.size();
        return instances.get(index);
    }
}
