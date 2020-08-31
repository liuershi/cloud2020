package cn.infocore.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/28 23:23
 * @Description
 */
@RestController
public class SentinelController {

    @GetMapping(value = "/sentinel/testA")
    public String testA(){
        /*try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "this is test A";
    }

    @GetMapping(value = "/sentinel/testB")
    public String testB(){
        return "this is test B";
    }

    /**
     * 测试 RT 模式下熔断降级
     * @return
     */
    @GetMapping(value = "/sentinel/testD")
    public String testD() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "this is test D";
    }

    /**
     * 测试 异常比例 模式下熔断降级
     * @return
     */
    @GetMapping(value = "/sentinel/testE")
    public String testE() {
        int test = 10 / 0;
        return "this is test E";
    }

    /**
     * 测试 异常数 模式下熔断降级
     * @return
     */
    @GetMapping(value = "/sentinel/testF")
    public String testF() {
        int test = 10 / 0;
        return "this is test F";
    }



    //========================
    /**
     * 测试热点参数限流
     * @return
     */
    @GetMapping(value = "/sentinel/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "fallBack_hotKey")
    public String testHotKey(
            @RequestParam(value = "p1", required = false) String p1,
            @RequestParam(value = "p2", required = false) String p2) {
        return "test hot key limiting " + (!StringUtils.isEmpty(p1)?p1 +" ":"") + (!StringUtils.isEmpty(p2)?p2:"");
    }

    public String fallBack_hotKey(String p1, String p2, BlockException e) {
        return "test hot key failed o(╥﹏╥)o";
    }
}
