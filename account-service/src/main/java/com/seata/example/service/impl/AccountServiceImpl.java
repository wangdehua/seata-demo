package com.seata.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.example.entity.Account;
import com.seata.example.mapper.AccountMapper;
import com.seata.example.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * create by: wangdh
 * description: 
 * create time: 2021/2/3 10:36
 * @author wangdehua
 * @param * @param null:
 * @return 
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
