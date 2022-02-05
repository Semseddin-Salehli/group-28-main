package az.developia.course.qrup28.dto.response.feign;

import lombok.Data;

@Data
public class Posts {
    public int id;
    public int userId;
    public String title;
    public String body;
}
