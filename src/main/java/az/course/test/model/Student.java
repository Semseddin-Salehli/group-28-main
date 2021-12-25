package az.course.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Student {
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private Integer age;
    private String privateColumn;

}
