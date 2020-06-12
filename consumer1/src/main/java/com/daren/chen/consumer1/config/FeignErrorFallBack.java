package com.daren.chen.consumer1.config;

import org.springframework.stereotype.Component;

import com.daren.chen.consumer1.service.ScServiceFallback;

import feign.hystrix.FallbackFactory;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/6/12 17:11
 */
@Component
public class FeignErrorFallBack implements FallbackFactory<ScServiceFallback> {

    private ScServiceFallback scServiceFallback;

    public FeignErrorFallBack(ScServiceFallback scServiceFallback) {
        this.scServiceFallback = scServiceFallback;
    }

    @Override
    public ScServiceFallback create(Throwable throwable) {
        System.out.println("打印异常   " + throwable.getMessage());
        // Map<String, Object> map = new HashMap<>();
        // map.put("result", "-1");
        // map.put("message", throwable.getMessage());
        return scServiceFallback;
    }
}
