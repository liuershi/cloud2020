package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.common.ParametersData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/25 22:58
 * @Description
 */
@RestController
//@RefreshScope //注意：该接口如果放在controller上则使controller无法取到值，未知BUG，需要将取值操作封装成对象交由容器管理后注入进来，例如下面的ParametersData
public class ConfigController {

    @Autowired
    private ParametersData data;

    @GetMapping(value = "/getConfigInfo")
    private String getConfigInfo() {
        return data.getConfigInfo();
    }
}
