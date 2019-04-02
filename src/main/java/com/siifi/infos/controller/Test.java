package com.siifi.infos.controller;

import javax.xml.ws.Endpoint;

public class Test {
    public static void main(String[] args) {
        String url = "http://192.168.10.128:8090/infos/webServer";
        WebServiceImpl webServiceImpl = new WebServiceImpl();
        Endpoint.publish(url,webServiceImpl);
        System.out.println("发布成功");
    }
}
