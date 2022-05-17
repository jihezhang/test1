package com.itheima.service;

import com.itheima.domain.SIMCode;

public interface SIMCodeService {
    public String sendCodeToSIM(String tele);
    public boolean checkCode(SIMCode simCode);
}
