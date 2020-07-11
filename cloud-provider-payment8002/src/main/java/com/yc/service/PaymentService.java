package com.yc.service;

import com.yc.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);                     //写操作

    Payment getPaymentById(@Param("id") Long id);    //读操作
}
