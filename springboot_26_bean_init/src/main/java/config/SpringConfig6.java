package config;

import domain.Dog;
import domain.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(MyImportSelector.class)
public class SpringConfig6 {
}
