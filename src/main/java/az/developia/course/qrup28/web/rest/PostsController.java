package az.developia.course.qrup28.web.rest;

import az.developia.course.qrup28.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @GetMapping
    public String getPosts() {
        return postsService.getAllPosts();
    }

}
