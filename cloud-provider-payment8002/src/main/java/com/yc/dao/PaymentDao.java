package com.yc.dao;

import com.yc.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * dao层的核心不是读，就是写
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);                     //写操作

    Payment getPaymentById(@Param("id") Long id);    //读操作
}
