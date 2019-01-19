package com.albert.web;

import com.albert.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Slf4j
@RestController
@RequestMapping("/consumer")
//配置默认服务降级返回方法
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

//    @GetMapping("/{id}")
//    public User queryById(@PathVariable(value = "id") Long id) {
////        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
////        ServiceInstance instance = instances.get(0);
////        log.info(instance.getHost());
////        log.info(instance.getScheme());
////        log.info(instance.getServiceId());
////        log.info(instance.getUri().toString());
////        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
//        String url = "http://user-service/user/" + id;
//        log.info("url = " + url);
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }


    @GetMapping("/{id}")
//    @HystrixCommand(fallbackMethod = "queryByIdFallBack")
    @HystrixCommand(commandProperties = {
//            设置改方法超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String queryById(@PathVariable(value = "id") Long id) {
        String url = "http://user-service/user/" + id;
        log.info("url = " + url);
        String user = restTemplate.getForObject(url, String.class);
        return user;
    }

    public String queryByIdFallBack(Long id) {
        return "服务正在忙....";
    }

    public String defaultFallback() {
        return "服务器太忙了...";
    }

}
