package az.developia.course.qrup28.service;

import az.developia.course.qrup28.dto.request.TeacherRequest;
import az.developia.course.qrup28.dto.response.TeacherResponse;

import java.util.List;

public interface TeacherService {

    List<TeacherResponse> getAll();

    Long add(TeacherRequest request);

    TeacherResponse update(Long id , TeacherRequest request);
}
