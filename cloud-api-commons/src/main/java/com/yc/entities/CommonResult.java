package com.yc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回前段通用的实体串
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T> {
    private Integer code;   //定义类型，如200，404
    private String message; //带过去的信息，如成功，失败
    private T      data;    //展现给前台的错误信息类型

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
