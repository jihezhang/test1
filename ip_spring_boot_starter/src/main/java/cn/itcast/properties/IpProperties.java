package cn.itcast.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("ipProperties")
@ConfigurationProperties(prefix = "tools.ip")
public class IpProperties {
    /**
     * 日志显示周期
     * */
    private Long cycle = 5L;
    /**
     * 是否设置重置数据
     * */
    private boolean cycleReset = false;
    /**
     * 日志输出模式 detail：明细模式 simple：简单模式
     * */
    private String model = LogModel.DETAIL.value;

    public enum LogModel{
       DETAIL("detail"),
       SIMPLE("simple");

       private String value;
       private LogModel(String value) {
           this.value=value;
       }

       public String getValue() {
           return value;
       }
    }

    public Long getCycle() {
        return cycle;
    }

    public void setCycle(Long cycle) {
        this.cycle = cycle;
    }

    public boolean isCycleReset() {
        return cycleReset;
    }

    public void setCycleReset(boolean cycleReset) {
        this.cycleReset = cycleReset;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
