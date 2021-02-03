package com.seata.example.controller;

import com.seata.example.entity.Account;
import com.seata.example.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: wangdh
 * description: 
 * create time: 2021/2/3 10:36
 * @author wangdehua
 * @param * @param null:
 * @return 
 */
@RestController
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/getById")
    public Account getById(@RequestParam Integer id) {
        return accountService.getById(id);
    }

    @RequestMapping("/updateById")
    public Boolean updateById(@RequestBody Account account) {
        return accountService.updateById(account);
    }
}
