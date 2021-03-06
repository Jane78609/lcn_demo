/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.leeue.stock.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * 订单实体类
 *
 * @author liyue
 * @date 2019/12/9 12:03
 */
@Data
public class OrderEntity {

    private Long id;
    /**
     * 订单名称
     */
    private String name;
    /**
     * 订单时间
     */
    private Date orderCreatetime;
    /**
     * 下单金额
     */
    private Double orderMoney;
    /**
     * 订单状态
     */
    private int orderState;
    /**
     * 商品id
     */
    private Long commodityId;

}
