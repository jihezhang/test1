package com.itheima.domain;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        try {
            Class<?> aClass = Class.forName("com.itheima.domain.Wolf");
            if (aClass != null) {
                return new String[]{"com.itheima.domain.Cat"};
            }
        } catch (ClassNotFoundException e) {
            return new String[0];
        }
        return null;
    }
}
