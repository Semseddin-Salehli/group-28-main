package az.course.test.dto.request;

import lombok.Data;

@Data
public class StudentRequest {
    private String name;
    private String surname;
    private String address;
    private String phone;
    private Integer age;
}
