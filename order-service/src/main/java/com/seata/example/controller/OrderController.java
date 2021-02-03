package com.seata.example.controller;

import com.seata.example.entity.Orders;
import com.seata.example.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: wangdh
 * description:
 * create time: 2021/2/3 10:59
 * @author wangdehua
 */
@RestController
public class OrderController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/save")
    public Boolean save(@RequestBody Orders orders) {
        return ordersService.save(orders);
    }
}
