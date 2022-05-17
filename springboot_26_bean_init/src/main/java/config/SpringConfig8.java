package config;

import domain.MyPostProcessor;
import org.springframework.context.annotation.Import;

@Import(MyPostProcessor.class)
public class SpringConfig8 {
}
