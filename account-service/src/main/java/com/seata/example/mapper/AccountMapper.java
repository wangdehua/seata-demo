package com.seata.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.example.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * create by: wangdh
 * description: 
 * create time: 2021/2/3 10:38
 * @author wangdehua
 * @param * @param null:
 * @return
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
