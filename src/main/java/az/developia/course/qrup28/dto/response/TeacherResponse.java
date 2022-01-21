package az.developia.course.qrup28.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherResponse {
    Long id;
    String name;
    String surname;
    List<StudentResponse> students;
}
