package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by abdou on 10/12/2017.
 */
@Configuration
@ComponentScan(basePackages = "station.service")
@Import({DataBaseConfiguration.class})
public class SpringConfig {
}
