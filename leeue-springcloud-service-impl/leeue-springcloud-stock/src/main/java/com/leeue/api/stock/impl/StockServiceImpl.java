package com.leeue.api.stock.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.leeue.api.entity.StockEntity;
import com.leeue.api.stock.StockService;
import com.leeue.base.BaseApiService;
import com.leeue.base.ResponseBase;
import com.leeue.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存接口实现类
 *
 * @author liyue
 * @date 2019/12/9 12:13
 */
@RestController
public class StockServiceImpl extends BaseApiService implements StockService {
    @Autowired
    private StockMapper stockMapper;


    @LcnTransaction //分布式事务注解
    @Transactional
    @RequestMapping("/inventoryReduction")
    public ResponseBase inventoryReduction(@RequestParam("commodityId") Long commodityId) {
        if (commodityId == null) {
            return setResultError("商品id不能为空!");
        }
        // 1.查询该商品id 是否存在
        StockEntity stockEntity = stockMapper.selectStock(commodityId);
        if (stockEntity == null) {
            return setResultError("商品id不存在!");
        }
        // 2.判断商品是否有超卖
        if (stockEntity.getStock() <= 0) {
            return setResultError("当前商品已经买完啦!");
        }
        // 3.减去库存1
        int updateStockResult = stockMapper.updateStock(commodityId);
        if (updateStockResult <= 0) {
            return setResultError("修改库存失败!");
        }
        return setResultSuccess("修改库存成功!");
    }

}
