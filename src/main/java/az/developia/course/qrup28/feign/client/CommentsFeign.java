package az.developia.course.qrup28.feign.client;

import az.developia.course.qrup28.dto.response.feign.Comments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "myFeign3" , url = "${fakeApi.url}")
public interface CommentsFeign {

    @GetMapping("comments")
    List<Comments> getAllComments();
}
