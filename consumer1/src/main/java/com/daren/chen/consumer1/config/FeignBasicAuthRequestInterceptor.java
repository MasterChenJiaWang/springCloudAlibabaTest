package com.daren.chen.consumer1.config;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/6/12 17:35
 */

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 自定义属于自己的认证方式
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
    public FeignBasicAuthRequestInterceptor() {}

    @Override
    public void apply(RequestTemplate template) {
        // 业务逻辑
        System.out.println("身份认证设置 .... ");
        template.header("token", "");
    }
}
