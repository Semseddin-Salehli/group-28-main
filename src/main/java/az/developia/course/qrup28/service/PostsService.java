package az.developia.course.qrup28.service;

import az.developia.course.qrup28.dto.response.feign.Posts;

import java.util.List;

public interface PostsService {
    List<Posts> getAllPosts();
}
