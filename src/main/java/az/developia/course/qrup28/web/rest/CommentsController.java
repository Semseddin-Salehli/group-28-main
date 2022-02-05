package az.developia.course.qrup28.web.rest;

import az.developia.course.qrup28.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final PostsService postsService;

    @GetMapping
    public String getComments() {
        return postsService.getAllPosts();
    }

}
