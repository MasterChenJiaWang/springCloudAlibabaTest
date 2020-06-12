package com.daren.chen.provider1.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.daren.chen.provider1.entity.Sc;
import com.daren.chen.provider1.service.IScService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chendaren
 * @since 2020-06-12
 */
@RestController
@RequestMapping("/sc")
public class ScController {

    @Autowired
    private IScService scService;

    @GetMapping("/findAll")
    public List<Sc> findAll() {
        return scService.list();
    }

    @GetMapping("/find/{id}")
    public List<Sc> findById(@PathVariable(value = "id") String id) {
        try {
            LambdaQueryWrapper<Sc> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Sc::getSId, id);
            return scService.list(queryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @PostMapping("/add1")
    public Map<String, Object> addInfo1(@RequestBody Sc sc) {
        Map<String, Object> map = new HashMap<>(8);
        boolean save = scService.save(sc);
        if (save) {
            map.put("result", save);
            map.put("data", sc);
            return map;
        }
        map.put("result", save);
        map.put("message", "保存失败!");
        return map;
    }

    /**
     *
     * @param sc
     * @return
     */
    @PostMapping(value = "/add2", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Map<String, Object> addInfo2(Sc sc) {
        Map<String, Object> map = new HashMap<>(8);
        boolean save = scService.save(sc);
        if (save) {
            map.put("result", save);
            map.put("data", sc);
            return map;
        }
        map.put("result", save);
        map.put("message", "保存失败!");
        return map;
    }

    /**
     *
     * @param sId
     * @param cId
     * @param score
     * @return
     */
    @PostMapping(value = "/add3", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Map<String, Object> addInfo3(@RequestParam(value = "sId") String sId,
        @RequestParam(value = "cId") String cId, @RequestParam(value = "score") BigDecimal score) {
        Map<String, Object> map = new HashMap<>(8);
        Sc sc = new Sc();
        sc.setCId(cId).setSId(sId).setScore(score);
        boolean save = scService.save(sc);
        if (save) {
            map.put("result", save);
            map.put("data", sc);
            return map;
        }
        map.put("result", save);
        map.put("message", "保存失败!");
        return map;
    }
}
