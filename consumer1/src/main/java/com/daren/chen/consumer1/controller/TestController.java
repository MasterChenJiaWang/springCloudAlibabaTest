package com.daren.chen.consumer1.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daren.chen.consumer1.dto.ScDto;
import com.daren.chen.consumer1.service.IScService;

/**
 * @Description:
 * @author: chenjiawang
 * @CreateDate: 2020/6/12 15:19
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IScService scService;

    /**
     *
     * @return
     */
    @GetMapping("/sc/findAll")
    public String findAllScInfo() {
        return scService.findAllScInfo();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/sc/find/{id}")
    public String findById(@PathVariable(value = "id") String id) {
        return scService.findScInfoById(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/sc/findById")
    public String findInfoById(@RequestParam(value = "id") String id) {
        return scService.findScInfoById(id);
    }

    @PostMapping(value = "/sc/add1", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String add1(@RequestBody String data) {
        return scService.add1(data);
    }

    @PostMapping("/sc/add12")
    public String add11(@RequestBody ScDto scDto) {
        return scService.add12(scDto);
    }

    @PostMapping(value = "/sc/add2", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String add2(@RequestParam(value = "sId") String sId, @RequestParam(value = "cId") String cId,
        @RequestParam(value = "score") BigDecimal score) {
        return scService.add2(sId, cId, score);
    }

    @PostMapping(value = "/sc/add3", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String add3(@RequestParam(value = "sId") String sId, @RequestParam(value = "cId") String cId,
        @RequestParam(value = "score") BigDecimal score) {
        return scService.add3(sId, cId, score);
    }
}
