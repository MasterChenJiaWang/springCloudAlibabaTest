package com.daren.chen.consumer1.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/6/12 16:11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScDto implements Serializable {

    private static final long serialVersionUID = 5657527474377093542L;
    private String sId;

    private String cId;

    private BigDecimal score;
}
