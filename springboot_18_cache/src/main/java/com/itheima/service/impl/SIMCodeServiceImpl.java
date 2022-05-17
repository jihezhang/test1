package com.itheima.service.impl;

import com.itheima.comfig.XmemcachedConfig;
import com.itheima.domain.SIMCode;
import com.itheima.service.SIMCodeService;
import com.itheima.utils.CacheCode;
import com.itheima.utils.SIMCodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class SIMCodeServiceImpl implements SIMCodeService {
    @Autowired
    CacheCode cacheCode;
//
    SIMCodeUtils simCodeUtils = new SIMCodeUtils();

    @Autowired
    private MemcachedClient memcachedClient;

    @Override
    public String sendCodeToSIM(String tele) {
        String code = simCodeUtils.generator(tele);
        try {
            memcachedClient.set(tele, 0, code);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean checkCode(SIMCode simCode) {
        String value = null;
        try {
            value = memcachedClient.get(simCode.getTele());
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return simCode.getCode().equals(value);
    }
//    @Autowired
//    private SIMCodeUtils simCodeUtils;
//    @Override
//    @CachePut(value= "SIMCache", key="#tele")
//    public String sendCodeToSIM(String tele) {
//        System.out.println(simCodeUtils);
//        String code = simCodeUtils.generator(tele);
//        return code;
//    }
//
//    @Override
//    public boolean checkCode(SIMCode simCode) {
//        String code = simCode.getCode();
//        String cCode = cacheCode.get(simCode.getTele());
//        return code.equals(cCode);
//    }




}
