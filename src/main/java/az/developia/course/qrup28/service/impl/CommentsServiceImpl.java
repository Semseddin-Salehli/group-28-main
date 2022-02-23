package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.response.feign.Comments;
import az.developia.course.qrup28.feign.client.CommentsFeign;
import az.developia.course.qrup28.service.CommentsServise;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CommentsServiceImpl implements CommentsServise {

    private final CommentsFeign feign;

    @Override
    public List<Comments> getAllComments() {
        return feign.getAllComments();
    }
}
