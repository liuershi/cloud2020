package cn.infocore.springcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 10:32
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    private T      data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
         this.data = null;
    }
}
