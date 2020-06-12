package com.daren.chen.consumer1.service;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.daren.chen.consumer1.config.FeignConfiguration;
import com.daren.chen.consumer1.dto.ScDto;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/6/12 15:37
 */
// @FeignClient(value = "provider1", path = "/sc", fallbackFactory = FeignErrorFallBack.class,
// configuration = FeignConfiguration.class)
@FeignClient(value = "provider1", path = "/sc", fallback = ScServiceFallback.class,
    configuration = FeignConfiguration.class)
public interface IScService {

    /**
     *
     * @return
     */
    @GetMapping("/findAll")
    String findAllScInfo();

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    String findScInfoById(@PathVariable(value = "id") String id);

    @PostMapping(value = "/add1", consumes = {MediaType.APPLICATION_JSON_VALUE})
    String add1(@RequestBody String data);

    @PostMapping(value = "/add1", consumes = {MediaType.APPLICATION_JSON_VALUE})
    String add12(@RequestBody ScDto scDto);

    @PostMapping(value = "/add2", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    String add2(@RequestParam(value = "sId") String sId, @RequestParam(value = "cId") String cId,
        @RequestParam(value = "score") BigDecimal score);

    @PostMapping(value = "/add3", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    String add3(@RequestParam(value = "sId") String sId, @RequestParam(value = "cId") String cId,
        @RequestParam(value = "score") BigDecimal score);
}
