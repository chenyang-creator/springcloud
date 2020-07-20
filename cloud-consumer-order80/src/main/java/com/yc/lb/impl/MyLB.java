package com.yc.lb.impl;

import com.yc.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自写负载均衡算法:模仿IRule接口的实现类：RoundRobinRule轮询编写
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //得到并把下标往下移，获得真正的eureka
    public final int getAndIncrement(){
        int current;
        int next;
        //自旋锁的步骤
        do {
            current = this.atomicInteger.get();
            //2147483647为整形的最大值
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****第几次访问次数next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
