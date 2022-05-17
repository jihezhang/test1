package com.itheima.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.itheima.domain.SIMCode;
import com.itheima.service.SIMCodeService;
import com.itheima.utils.CacheCode;
import com.itheima.utils.SIMCodeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class SIMCodeServiceImpl implements SIMCodeService {
    @Autowired
    CacheCode cacheCode;
    SIMCodeUtils simCodeUtils = new SIMCodeUtils();

    @CreateCache(name = "jetCache", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL)
    private Cache<String, String> jetCache;

    @Override
    public String sendCodeToSIM(String tele) {
        String code = simCodeUtils.generator(tele);
        jetCache.put(tele, code);
        return code;
    }

    @Override
    public boolean checkCode(SIMCode simCode) {
        String code = simCode.getCode();
        String value = jetCache.get(simCode.getTele());
        return code.equals(value);
    }
}
