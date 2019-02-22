# 目录说明
## app
>> spring boot微服务项目代码，集成了前端jsp,freemarker,thymeleaf.后端集成servlet,filter,listener,全局异常处理，spring admin,两种定时任务框架，oracle数据库支持，mybatis,ehcache缓存，RabbitMQ的direct,topic,fanout消息发送方式
## rabbitMQ_producter
>> rabbit消息的生产者，用来和demo组合，测试rabbitMQ消息中间件
## rabbitMQ_publisher1
>> 未实现
## springbootAdmin_client
>> spring boot项目监控测试项目，属于被监控的一方
## springbootAdmin_client
  spring boot项目监控程序，所有需要被监控的springboot 项目需要在自己的配置文件中添加监控服务的地址
## springcloud_eureka_server1
>> springcloud_eureka服务注册中心集群节点1,用来进行服务的注册和发现
## springcloud_eureka_server2
>> springcloud_eureka服务注册中心集群节点2，用来进行服务的注册和发现
## springcloud_eureka_producter
>> 服务提供者，被注册到服务中心提供服务
## springcloud_eureka_consumer
>> 服务的使用者，注册到服务中心，从服务中心获取服务