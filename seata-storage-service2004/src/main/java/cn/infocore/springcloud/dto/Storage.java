package cn.infocore.springcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 11:47
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;
    private Long productId;
    private Long total;
    private Long used;
    private Long residue;
}
