package com.leeue.feign;


import com.leeue.api.stock.StockService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("leeue-stock")
public interface StockFeign extends StockService {

}
