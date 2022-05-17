package cn.itcast.service;

import cn.itcast.autoConfig.IpAutoConfig;
import cn.itcast.properties.IpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class IpCountService {
    private Map<String, Integer> map = new HashMap<>();

    @Autowired
    private HttpServletRequest httpServletRequest;

    public void count() {
        //获取当前操作的IP地址
        String ip = httpServletRequest.getRemoteAddr();
        System.out.println("已经得到IP，IP为" + ip);
        if (map.get(ip) == null) {
            map.put(ip, 1);
        } else {
            map.put(ip, map.get(ip) + 1);
        }
    }

    @Autowired
    private IpProperties ipProperties;

//    @Scheduled(cron = "0/${tools.ip.cycle:5} * * * * ?") 这种方式用不到IpProperties中的配置属性了
    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * ?")
    public void print(){

        if (ipProperties.getModel().equals(IpProperties.LogModel.DETAIL.getValue())) {
            System.out.println("      IP访问控制");
            System.out.println("+-----ip-address-----+--num--+");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(String.format("|%18s  |%5d  |", key, value));
            }
            System.out.println("+--------------------+-------+");
        } else if (ipProperties.getModel().equals(IpProperties.LogModel.SIMPLE.getValue())) {
            System.out.println("      IP访问控制");
            System.out.println("+-----ip-address-----+");
            for (String key : map.keySet()) {
                System.out.println(String.format("|%18s  |", key));
            }
            System.out.println("+--------------------+");
        }


        if (ipProperties.isCycleReset()) {
            map.clear();
        }
    }
}
