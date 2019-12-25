package com.leeue.stock.api.service;


import com.leeue.base.ResponseBase;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 订单接口
 *
 * @author liyue
 * @date 2019/12/9 12:03
 */
public interface IOrderService {

    /**
     * 用户下单后调用库存服务进行扣库存
     *
     * @param i
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/addOrderAndStock")
    ResponseBase addOrderAndStock(int i) throws Exception;
}
