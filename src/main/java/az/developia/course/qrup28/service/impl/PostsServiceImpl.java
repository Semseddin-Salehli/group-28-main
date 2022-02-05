package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.response.feign.Posts;
import az.developia.course.qrup28.feign.client.PostsFeign;
import az.developia.course.qrup28.service.PostsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsFeign feign;
    private final ObjectMapper objectMapper;

    @Override
    public String getAllPosts() {
        try {
            List<Posts> allPosts = feign.getAllPosts();
            return objectMapper.writeValueAsString(allPosts);
        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
