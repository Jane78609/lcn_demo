package com.leeue.api.stock;

import com.leeue.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface StockService {

    // 根据商品id 减库存数量
    @RequestMapping("/inventoryReduction")
    public ResponseBase inventoryReduction(@RequestParam("commodityId") Long commodityId);

}
