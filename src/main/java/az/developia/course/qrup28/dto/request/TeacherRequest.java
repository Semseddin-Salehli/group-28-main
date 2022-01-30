package az.developia.course.qrup28.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherRequest {
    String name;
    String surname;
    List<Long> studentIds;
}
