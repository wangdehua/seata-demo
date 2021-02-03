package com.seata.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.example.entity.Product;
import com.seata.example.mapper.ProductMapper;
import com.seata.example.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * create by: wangdh
 * description: 
 * create time: 2021/2/3 11:26
 * @author wangdehua
 * @param * @param null:
 * @return
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
