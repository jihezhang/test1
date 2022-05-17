package com.itheima.config;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@ConfigurationProperties(prefix = "servers")
//@Component
@Data
@Validated
public class ServerConfig {
    private String ipAddress;
    @Max(value = 8088, message = "最大值不能超过8088")
    @NotEmpty
    private Integer port;
    private long timeout;
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeout;
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}
