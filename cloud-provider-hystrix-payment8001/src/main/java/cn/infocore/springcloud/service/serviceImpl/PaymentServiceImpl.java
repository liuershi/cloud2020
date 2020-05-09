package cn.infocore.springcloud.service.serviceImpl;

import cn.hutool.core.util.IdUtil;
import cn.infocore.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/5/8 10:16
 * @Description
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String getPaymentInfo_ok(Integer id) {
        String ok = "当前线程: " + Thread.currentThread().getName() + " ;处理结果： " + id + " ; OK";
        log.info(ok);
        return ok;
    }

    /**
     * 测试超时和异常状态是否能正常进行服务降级
     * @param id
     * @return
     */
    @Override
    // 超过设置的超时时间5000毫秒(value)则去调用paymentInfo_timeoutHandler进行服务降级
    // fallbackMethod：超时或异常经常降级服务调用的方法；name：超时异常声明；value：超时的时间阈值，单位为毫秒
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String getPaymentInfo_timeout(Integer id) {
//        int error = 10 / 0; // 程序异常

        int timeNumber = 3; // 超时错误
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String timeout = "当前线程: " + Thread.currentThread().getName() + " ;处理结果： " + id + " ; timeout; 耗时(秒):" + timeNumber;
        return timeout;
    }

    /**
     * 超时或程序异常用来进行服务降级的方案
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_timeoutHandler(Integer id) {
        return "当前线程: " + Thread.currentThread().getName() + " ;服务超时或者程序异常，请稍后再试！！！ ID： " + id;
    }

    //======服务熔断
    //注意：服务熔断的备选方法paymentCircuitBreaker_fallback的参数列表必须与本方法(paymentCircuitBreaker)一致，否则会产生异常
    //下面这段组合注解的意思是，当在时间窗口10秒内请求次数10次的话如果出现异常的概率在60%及以上则会熔断服务，正常访问请求也会走熔断定义的fallbackMethod方法，即paymentCircuitBreaker_fallback()方法
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//异常概率，达到后进行熔断
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("*********id 不能为负数") ;
        }
        return Thread.currentThread().getName() + "调用成功；服务流水号为：" + IdUtil.simpleUUID();
    }
    public String paymentCircuitBreaker_fallback(Integer id) {
        return "服务ID:" + id + "现在已经熔断，请稍后重试！！！o(╥﹏╥)o";
    }
}
