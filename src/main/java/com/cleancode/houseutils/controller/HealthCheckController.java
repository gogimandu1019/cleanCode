package com.cleancode.houseutils.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *@author - minseon.k
 * 서버 상태 점검
 * */
@RestController
public class HealthCheckController {
    @GetMapping("/api/ping")
    public String ping(){
        return "OK";
    }
}
