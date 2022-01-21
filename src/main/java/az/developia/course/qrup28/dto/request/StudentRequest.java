package az.developia.course.qrup28.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String address;

    @NotBlank
    private String phone;

    @NotNull
    private Integer age;

    @NotNull
    private SeriesRequest series;

    @NotNull
    private Long schoolClassId;
}
