package cn.infocore.springcloud.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/4/12 22:39
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T result;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
