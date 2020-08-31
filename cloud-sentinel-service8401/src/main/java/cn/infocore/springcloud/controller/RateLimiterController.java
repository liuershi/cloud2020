package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.entites.CommonResult;
import cn.infocore.springcloud.myhandler.CustomizeHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/29 23:04
 * @Description 演示同HystrixCommon注解一样，通过@SentinelResource将异常处理和业务解耦，同时解决代码膨胀问题
 */
@RestController
public class RateLimiterController {

    @GetMapping(value = "/sentinel/getResource")
    @SentinelResource(value = "getResource", blockHandler = "fallback_getResource")
    public CommonResult getResource() {
        return new CommonResult(200, "获取资源信息成功^_^", "测试通过资源名限流");
    }

    /**
     * 注意，注意，注意：
     *          降级方法中参数列表必须包含BlockException属性，否则将不会调用降级方法
     * @param exception
     * @return
     */
    public CommonResult fallback_getResource(BlockException exception){
        return new CommonResult(444, "获取资源信息失败o(╥﹏╥)o, exception:" + exception.getClass().getCanonicalName(), null);
    }

    @GetMapping(value = "/sentinel/getUrl")
    @SentinelResource(value = "getUrl")
    public CommonResult getUrl() {
        return new CommonResult(200, "获取资源URL信息成功^_^", "测试通过URL限流");
    }

    /**
     * 自定义限流降级处理器，解耦，避免代码膨胀
     * @return
     */
    @GetMapping(value = "/sentinel/customizeLimiter")
    @SentinelResource(value = "customizeLimiter" , blockHandlerClass = CustomizeHandler.class, blockHandler = "handlerTwo")
    public CommonResult customizeLimiter() {
        return new CommonResult(200, "自定义限流成功^_^", "哈哈哈哈哈");
    }
}
