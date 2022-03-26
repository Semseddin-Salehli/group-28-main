package az.developia.course.qrup28.web.rest;

import az.developia.course.qrup28.dto.response.feign.Comments;
import az.developia.course.qrup28.dto.response.feign.OtherUser;
import az.developia.course.qrup28.dto.response.feign.Posts;
import az.developia.course.qrup28.service.CommentsServise;
import az.developia.course.qrup28.service.OtherUsersService;
import az.developia.course.qrup28.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feigns")
@RequiredArgsConstructor
public class FeignController {

    private final PostsService postsService;
    private final CommentsServise commentsServise;
    private final OtherUsersService usersService;

    @GetMapping("/comments")
    public List<Comments> getComments() {
        return commentsServise.getAllComments();
    }

    @GetMapping("/users")
    public List<OtherUser> getUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/posts")
    public List<Posts> getPosts() {
        return postsService.getAllPosts();
    }
}

