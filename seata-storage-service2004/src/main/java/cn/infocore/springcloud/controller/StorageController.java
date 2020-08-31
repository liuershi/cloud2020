package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.dto.CommonResult;
import cn.infocore.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 13:36
 * @Description
 */
@RestController
public class StorageController {

    @Resource
    private StorageService service;

    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        service.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功");
    }
}
