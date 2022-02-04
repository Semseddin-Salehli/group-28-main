package az.developia.course.qrup28;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class Qrup28Application {

    public static void main(String[] args) {
        SpringApplication.run(Qrup28Application.class, args);


    }

}
