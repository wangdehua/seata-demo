package com.seata.example.controller;

import com.seata.example.entity.Account;
import com.seata.example.entity.Orders;
import com.seata.example.entity.Product;
import com.seata.example.service.IAccountService;
import com.seata.example.service.IOrderService;
import com.seata.example.service.IProductService;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：wangdh
 * @date ：Created in 2021/2/3 11:06
 * @description：controller测试
 */
@RequestMapping(value = "/test")
@RestController
@Slf4j
public class ExampleController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IProductService productService;

    private Lock lock = new ReentrantLock();

    /**
     * 秒杀下单分布式事务测试
     * @return
     * @throws TransactionException
     */
    @GetMapping(value = "/testCommit")
    @GlobalTransactional(rollbackFor = Exception.class)
    public Object testCommit() throws TransactionException {
        lock.lock();
        try {
            Product product = productService.getById(100);
            if (product.getStock() > 0) {
                LocalDateTime now = LocalDateTime.now();
                log.error("seata分布式事务Id:{}", RootContext.getXID());
                Account account = accountService.getById(100);
                Orders orders = new Orders();
                orders.setCreateTime(now);
                orders.setProductId(product.getId());
                orders.setReplaceTime(now);
                orders.setSum(1);
                orders.setAmount(product.getPrice());
                orders.setAccountId(account.getId());
                product.setStock(product.getStock() - 1);
                account.setSum(account.getSum() != null ? account.getSum() + 1 : 1);
                account.setLastUpdateTime(now);
                Boolean boolProduct = productService.updateById(product);
                log.info(" 产品库存扣除执行结果 : {} " , boolProduct );
                Boolean boolAccount = accountService.updateById(account);
                log.info(" 账户变动执行结果 : {} " , boolAccount );
                //手动制造bug
                //int i=1/0;
                Boolean boolSave = orderService.save(orders);
                log.info(" 下单结果 : {} " , boolSave );
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("载入事务{}进行回滚" + e.getMessage(), RootContext.getXID());
            GlobalTransactionContext.reload(RootContext.getXID()).rollback();
            return false;
        } finally {
            lock.unlock();
        }
    }
}