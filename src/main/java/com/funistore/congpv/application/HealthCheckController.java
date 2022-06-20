package com.funistore.congpv.application;

import org.springframework.web.bind.annotation.GetMapping;

public class HealthCheckController extends BaseController{
    @GetMapping("/")
    public String ping(){
        return "pong";
    }
}
