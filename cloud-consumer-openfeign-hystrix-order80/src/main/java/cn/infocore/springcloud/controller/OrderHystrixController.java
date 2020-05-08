package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/5/8 11:07
 * @Description
 */
@RestController
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService service;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String getPaymentInfo_ok(@PathVariable("id") Integer id){
        return service.getPaymentInfo_ok(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    // 超过设置的超时时间1.5秒(value)则去调用paymentInfo_timeoutHandler进行服务降级
    // fallbackMethod：超时或异常经常降级服务调用的方法；name：超时异常声明；value：超时的时间阈值，单位为毫秒
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String getPaymentInfo_timeout(@PathVariable("id") Integer id){
        int error = 10 / 0;
        return service.getPaymentInfo_timeout(id);
    }

    /**
     * 客户端模块的超时或者程序错误进行服务降级的方法
     * @param id
     * @return
     */
    public String paymentInfo_timeoutHandler(Integer id) {
        return "ID：" + id +"\r" + "服务器繁忙请稍后重试或者程序内部错误请检查！！！o(╥﹏╥)o";
    }
}
