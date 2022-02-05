package az.developia.course.qrup28.dto.response.feign;

import lombok.Data;

@Data
public class Comments {
    public int id;
    public int postId;
    public String name;
    public String email;
    public String body;
}
