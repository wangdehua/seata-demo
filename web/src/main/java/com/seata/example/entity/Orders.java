package com.seata.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * create by: wangdh
 * description:
 * create time: 2021/2/3 11:06
 * @author wangdehua
 * @param * @param null:
 * @return
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer productId;

    private BigDecimal amount;

    private Integer sum;

    private Integer accountId;

    private LocalDateTime createTime;

    private LocalDateTime replaceTime;

}
