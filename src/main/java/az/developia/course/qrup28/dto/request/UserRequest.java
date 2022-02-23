package az.developia.course.qrup28.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    String username;
    @Size(min = 8)
    String password;
    String roles;
}
