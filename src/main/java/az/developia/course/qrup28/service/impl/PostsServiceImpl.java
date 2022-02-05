package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.response.feign.Posts;
import az.developia.course.qrup28.feign.client.PostsFeign;
import az.developia.course.qrup28.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsFeign feign;

    @Override
    public List<Posts> getAllPosts() {
        return feign.getAllPosts();
    }
}
