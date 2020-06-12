package com.daren.chen.consumer1.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.daren.chen.consumer1.dto.ScDto;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/6/12 17:44
 */
@Component
public class ScServiceFallback implements IScService {

    @Override
    public String findAllScInfo() {
        return null;
    }

    @Override
    public String findScInfoById(String id) {
        return null;
    }

    @Override
    public String add1(String data) {
        return null;
    }

    @Override
    public String add12(ScDto scDto) {
        return null;
    }

    @Override
    public String add2(String sId, String cId, BigDecimal score) {
        System.out.println("报错了.........................");
        return "调用错误";
    }

    @Override
    public String add3(String sId, String cId, BigDecimal score) {
        return null;
    }
}
