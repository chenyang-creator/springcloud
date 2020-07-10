package com.yc.controller;

import com.yc.entities.CommonResult;
import com.yc.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    //地址
//    public static final String PAYMENT_URL = "http://localhost:8002";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    //写操作
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        /**
         * 参数一： REST请求地址
         * 参数二： 请求参数
         * 参数三： HTTP响应转换被转换成的对象类型
         */
        //可以打印日志
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }
    //读操作
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        //可以打印日志
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
