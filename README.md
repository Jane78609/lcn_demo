# lcn_demo
测试分布式事务

本项目采用zuul做路由管理,eureka作为服务注册发现，FeignClient作远程调用(RPC),LCN做分布式事务管理  
访问 http://127.0.0.1:9000/api-order/addOrderAndStock?i=1  订单表插入一条记录  库存减1  
访问 http://127.0.0.1:9000/api-order/addOrderAndStock?i=0  订单插入回滚 库存回滚 

该Demo项目来源码云 https://gitee.com/leeue14/springcloud-lcn   
改了端口和数据库连接即可启动,如果出现You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support. 需要在jdbc的url上加上serverTimezone=UTC(https://www.cnblogs.com/mao2080/p/9451612.html)    
LCN官网   http://www.txlcn.org/zh-cn




