package com.seata.example.service;

import com.seata.example.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by: wangdh
 * description:
 * create time: 2021/2/3 11:13
 * @author wangdehua
 * @param * @param null:
 * @return
 */
@FeignClient(value = "account-service")
public interface IAccountService {

    @RequestMapping(value = "/getById")
    Account getById(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "/updateById")
    Boolean updateById(@RequestBody Account account);
}
