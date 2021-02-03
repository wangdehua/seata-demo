package com.seata.example.service;

import com.seata.example.entity.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by: wangdh
 * description:
 * create time: 2021/2/3 11:14
 * @author wangdehua
 * @param * @param null:
 * @return
 */
@FeignClient(value = "order-service")
public interface IOrderService {

    @RequestMapping(value = "/save")
    Boolean save(@RequestBody Orders orders);
}
