package com.yc.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced   起到负载均衡的作用
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
