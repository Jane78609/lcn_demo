package com.leeue.api.order.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.leeue.base.BaseApiService;
import com.leeue.base.ResponseBase;
import com.leeue.feign.StockFeign;
import com.leeue.mapper.OrderMapper;
import com.leeue.stock.api.entity.OrderEntity;
import com.leeue.stock.api.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 订单接口实现类
 *
 * @author liyue
 * @date 2019/12/9 12:13
 */
@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StockFeign stockFeign;

    @LcnTransaction //分布式事务注解
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseBase addOrderAndStock(int i) throws Exception {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setName("永久会员充值");
        orderEntity.setOrderCreatetime(new Date());
        // 价格是300元
        orderEntity.setOrderMoney(300d);
        // 状态为 未支付
        orderEntity.setOrderState(0);
        Long commodityId = 30L;
        // 商品id
        orderEntity.setCommodityId(commodityId);
        // 1.先下单，创建订单
        int orderResult = orderMapper.addOrder(orderEntity);
        System.out.println("orderResult:" + orderResult);
        // 2.下单成功后,调用库存服务
        ResponseBase inventoryReduction = stockFeign.inventoryReduction(commodityId);
        if (inventoryReduction.getRtnCode() != 200) {
            // 第一种方法，使用手动事务 -
            //  TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            // 第二种方法，使用aop,捕获异常后，进行手动事务回滚，获取将异常抛出给上一层，外面回滚。
            throw new Exception("调用库存服务接口失败，开始回退订单事务代码");
        }
        int reuslt = 1 / i;
        return setResultSuccess("下单成功!");
    }
}
