# spring-cloud-demo


## 1. 什么是springCloud？
官网地址:

http://spring.io/projects/spring-cloud

官网介绍:

> Spring Cloud provides tools for developers to quickly build some of the common patterns in distributed systems (e.g. configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus, one-time tokens, global locks, leadership election, distributed sessions, cluster state).
 Coordination of distributed systems leads to boiler plate patterns, and using Spring Cloud developers can quickly stand up services and applications that implement those patterns. They will work well in any distributed environment, including the developer’s own laptop, bare metal data centres, and managed platforms such as Cloud Foundry.

有道翻译过来就是：
> Spring Cloud为开发人员提供了快速构建分布式系统中一些常见模式的工具（例如配置管理，服务发现，断路器，智能路由，微代理，控制总线，一次性令牌，全局锁定，领导选举，分布式会话，集群状态）。分布式系统的协调导致锅炉板模式，使用Spring Cloud开发人员可以快速站起来实现这些模式的服务和应用程序。它们适用于任何分布式环境，包括开发人员自己的笔记本电脑，裸机数据中心和Cloud Foundry等托管平台。


大致就是集成了很多分布式的工具,比如服务注册中心，熔断器，负载均衡等。



## 2. 项目介绍

这里只是搭建了springCloud一部分组件,都是单机版，没有集群，主要用到的是：

- Eureka：注册中心
- Zuul：服务网关
- Ribbon：负载均衡
- Feign：服务调用
- Hystix：熔断器

版本: 

- Finchley.SR2


