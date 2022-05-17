package com.itheima.controller;

import com.itheima.domain.SIMCode;
import com.itheima.service.SIMCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sim")
public class SIMCodeController {

    @Autowired
    private SIMCodeService simCodeService;

    @GetMapping
    public String getCode(String tele){
        String code = simCodeService.sendCodeToSIM(tele);
        return code;
    }

    @PostMapping
    public boolean checkCode(SIMCode simCode) {
        return simCodeService.checkCode(simCode);
    }

}
