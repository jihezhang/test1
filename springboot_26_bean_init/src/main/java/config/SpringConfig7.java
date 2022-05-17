package config;

import domain.MyImportSelector;
import domain.MyRegistrar;
import org.springframework.context.annotation.Import;


@Import(MyRegistrar.class)
public class SpringConfig7 {
}
