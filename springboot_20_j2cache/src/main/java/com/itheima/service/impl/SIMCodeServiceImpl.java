package com.itheima.service.impl;

import com.itheima.domain.SIMCode;
import com.itheima.service.SIMCodeService;
import com.itheima.utils.CacheCode;
import com.itheima.utils.SIMCodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class SIMCodeServiceImpl implements SIMCodeService {
    @Autowired
    CacheCode cacheCode;
    SIMCodeUtils simCodeUtils = new SIMCodeUtils();

    @Autowired
    private CacheChannel cacheChannel;

    @Override
    @CachePut(value= "SIMCache", key="#tele")
    public String sendCodeToSIM(String tele) {
        String code = simCodeUtils.generator(tele);
        cacheChannel.set("sim", tele, code);
        return code;
    }

    @Override
    public boolean checkCode(SIMCode simCode) {
        String code = simCode.getCode();
        String cCode = cacheChannel.get("sim", simCode.getTele()).asString();
        return code.equals(cCode);
    }
}
