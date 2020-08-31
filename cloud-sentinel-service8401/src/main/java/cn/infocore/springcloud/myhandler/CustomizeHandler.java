package cn.infocore.springcloud.myhandler;

import cn.infocore.springcloud.entites.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/29 23:38
 * @Description
 */
public class CustomizeHandler {

    public static CommonResult handlerOne(BlockException e) {
        return new CommonResult(444, "自定义限流处理器-------1", "o(╥﹏╥)o");
    }

    public static CommonResult handlerTwo(BlockException e) {
        return new CommonResult(444, "自定义限流处理器-------2", "o(╥﹏╥)o");
    }
}
