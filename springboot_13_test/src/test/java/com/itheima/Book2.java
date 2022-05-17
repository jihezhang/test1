package com.itheima;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Book2 {
    private Integer Id;
    private String name;
    private String description;
    private String type;
}
