package cn.infocore.springcloud.service;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/8/31 13:32
 * @Description
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
