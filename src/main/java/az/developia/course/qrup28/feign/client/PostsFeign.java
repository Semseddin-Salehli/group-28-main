package az.developia.course.qrup28.feign.client;

import az.developia.course.qrup28.dto.response.feign.Posts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "myFeign2" , url = "${fake.url}")
public interface PostsFeign {

    @GetMapping("/posts")
    List<Posts> getAllPosts();
}
