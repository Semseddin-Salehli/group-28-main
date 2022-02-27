package az.developia.course.qrup28.service;


import az.developia.course.qrup28.dto.request.StudentRequest;
import az.developia.course.qrup28.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getAll();

    Long add(StudentRequest studentRequest);

    StudentResponse getById(Long id);

    StudentResponse update(StudentRequest studentRequest, Long studentId);

    StudentResponse delete(Long studentId);
}
