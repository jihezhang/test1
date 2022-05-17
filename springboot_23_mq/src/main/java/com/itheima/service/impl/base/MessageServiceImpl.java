package com.itheima.service.impl.base;

import com.itheima.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//@Service
public class MessageServiceImpl implements MessageService {

    ArrayList<String> list = new ArrayList<>();
    @Override
    public void sendMessage(String id) {
        System.out.println("d代发短信已经进入处理队列，id" + id);
        list.add(id);
    }

    @Override
    public String doMessage() {
        String id = list.remove(0);
        System.out.println("已完成短信发送业务,id" + id);
        return id;
    }
}
