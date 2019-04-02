package com.siifi.infos.controller;

import javax.jws.WebService;

import java.util.Date;

@WebService
public class WebServiceImpl {
    public String name(String name){
        System.out.println("接收到了客户端的请求，时间 ： "+new Date());
        name = "你好呀!" + name + new Date();
        System.out.println("************返回数据"+name);
        return name;
    }
}
