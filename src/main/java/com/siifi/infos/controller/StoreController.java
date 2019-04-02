package com.siifi.infos.controller;


import com.siifi.infos.entity.Store;

import com.siifi.infos.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/infos")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Value(value = "${roncoo.secret}")   //32位随机字符串
    private String secret;

    @Value(value = "${roncoo.number}")   //随机整数
    private int number;

    @RequestMapping(value = "/get")
    public Map<String, Object> get(@RequestParam String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("address", "宏大北路店");
        map.put("secret", secret);
        map.put("number", number);
        map.put("date", new Date());
        return map;
    }
}
