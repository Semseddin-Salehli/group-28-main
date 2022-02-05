package az.developia.course.qrup28.service;

import az.developia.course.qrup28.dto.response.feign.Comments;
import java.util.List;

public interface CommentsServise {
    List<Comments> getAllComments();
}
