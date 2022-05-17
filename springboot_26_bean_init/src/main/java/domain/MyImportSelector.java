package domain;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        boolean flag = importingClassMetadata.hasAnnotation("org.springframework.context.annotation.Configuration");
        System.out.println(flag);
        return new String[]{"domain.Cat"};
    }
}
