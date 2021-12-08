package az.developia.course.qrup28.configuration;

import az.developia.course.qrup28.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Employee employee() {
        return new Employee("Mahammad", "Alishov");
    }
}
