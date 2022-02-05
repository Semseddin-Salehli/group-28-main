package az.developia.course.qrup28.feign.client;

import java.util.List;
import az.developia.course.qrup28.dto.response.feign.OtherUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "myFeign" , url = "${fakeApi.url}")
public interface OtherUserFeign {

    @GetMapping("/users")
    List<OtherUser> getAllUser();
}
