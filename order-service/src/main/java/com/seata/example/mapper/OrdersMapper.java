package com.seata.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.example.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * create by: wangdh
 * description:
 * create time: 2021/2/3 10:57
 * @author wangdehua
 * @param * @param null:
 * @return 
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}
