package com.seata.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.example.entity.Orders;
import com.seata.example.mapper.OrdersMapper;
import com.seata.example.service.IOrdersService;
import org.springframework.stereotype.Service;

/**
 * create by: wangdh
 * description:
 * create time: 2021/2/3 10:58
 * @author wangdehua
 * @param * @param null:
 * @return
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
