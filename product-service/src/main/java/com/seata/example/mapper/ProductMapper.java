package com.seata.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.example.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * create by: wangdh
 * description:
 * create time: 2021/2/3 11:24
 * @author wangdehua
 * @param * @param null:
 * @return
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
