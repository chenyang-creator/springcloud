package com.yc.controller;

import com.yc.entities.CommonResult;
import com.yc.entities.Payment;
import com.yc.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
//pom文件中的lombok包起的作用，如果不想每次都写private  final Logger logger = LoggerFactory.getLogger(当前类名.class);
//可以用注解@Slf4j;
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){       //@RequestBody注解接收返回的json格式字符串
        int result = paymentService.create(payment);
        log.info("*****插入结果"+result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功,端口号serverPort"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败,端口号serverPort"+serverPort,null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,端口号serverPort"+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询失败"+id+"端口号serverPort"+serverPort,null);
        }
    }

}


