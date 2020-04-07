package com.atguigu.springcloud.alibaba.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 库存服务
 *
 **/
@Service
public interface AccountService {
    /**
     * 减库存
     *
     * @param userId 用户id
     * @param money  金额
     * @return
     */
    void decrease(Long userId, BigDecimal money);
}
