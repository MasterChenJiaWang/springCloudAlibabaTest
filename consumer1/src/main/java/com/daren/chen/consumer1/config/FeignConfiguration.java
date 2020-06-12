package com.daren.chen.consumer1.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.Request;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

/**
 *
 *
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/6/12 17:24
 */
@Configuration
public class FeignConfiguration {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    /**
     * 通过 Options 可以配置连接超时时间和读取超时时间
     *
     * @return
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }

    // @Bean
    // public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    // return new BasicAuthRequestInterceptor("user", "password");
    // }

    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

    /**
     * new一个form编码器，实现支持form表单提交
     *
     * @return
     */
    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

    /**
     * 开启Feign的日志
     *
     * @return
     */
    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }

}
