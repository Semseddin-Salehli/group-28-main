package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.configuration.AppProperties;
import az.developia.course.qrup28.dto.response.feign.Comments;
import az.developia.course.qrup28.feign.client.CommentsFeign;
import az.developia.course.qrup28.service.CommentsServise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentsServiceImpl implements CommentsServise {

    private final CommentsFeign feign;

    @Override
    public List<Comments> getAllComments() {
        return feign.getAllComments();
    }
}
