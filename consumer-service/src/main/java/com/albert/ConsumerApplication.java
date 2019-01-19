package com.albert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
////服务熔断
//@EnableCircuitBreaker
////服务调用
//@EnableDiscoveryClient
//@SpringBootApplication

@SpringCloudApplication
public class ConsumerApplication {

    @Bean
    //  负载均衡加载
    @LoadBalanced
    public RestTemplate restTemplate () {
        //这里可以选择不同的不同请求客户端，默认使用URLConnection
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }

}

