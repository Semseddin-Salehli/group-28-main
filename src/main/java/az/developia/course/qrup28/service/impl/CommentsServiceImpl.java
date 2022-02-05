package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.response.feign.Comments;
import az.developia.course.qrup28.feign.client.CommentsFeign;
import az.developia.course.qrup28.service.CommentsServise;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentsServiceImpl implements CommentsServise {

    private final CommentsFeign feign;
    private final ObjectMapper objectMapper;

    @Override
    public String getAllComments() {
        try {
            List<Comments> allComments = feign.getAllComments();
            return objectMapper.writeValueAsString(allComments);
        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
