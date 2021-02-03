package com.seata.example.controller;

import com.seata.example.entity.Product;
import com.seata.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: wangdh
 * description:
 * create time: 2021/2/3 11:27
 * @author wangdehua
 * @param * @param null:
 * @return
 */
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/getById")
    public Product getById(@RequestParam(name = "id") Integer id) {
        return productService.getById(id);
    }

    @RequestMapping("/updateById")
    public Boolean updateById(@RequestBody Product product) {
        return productService.updateById(product);
    }
}
