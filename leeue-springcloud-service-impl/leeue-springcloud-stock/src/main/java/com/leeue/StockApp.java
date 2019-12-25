/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.leeue;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 库存服务
 *
 * @author liyue
 * @date 2019/12/9 12:13
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@MapperScan(basePackages = "com.leeue.mapper")
/**TC开启分布式事务注解**/
@EnableDistributedTransaction
public class StockApp {
    public static void main(String[] args) {
        SpringApplication.run(StockApp.class, args);
    }
}
