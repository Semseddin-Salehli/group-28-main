package az.developia.course.qrup28;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@ConfigurationPropertiesScan(basePackages = "az.developia.course.qrup28.configuration")
public class Qrup28Application {

    public static void main(String[] args) {
        SpringApplication.run(Qrup28Application.class, args);
    }

}
