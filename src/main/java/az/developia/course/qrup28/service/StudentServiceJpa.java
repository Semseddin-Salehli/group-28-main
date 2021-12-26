package az.developia.course.qrup28.service;

import az.developia.course.qrup28.dto.request.StudentRequest;
import az.developia.course.qrup28.dto.response.StudentResponse;

import java.util.List;

public interface StudentServiceJpa {

    List<StudentResponse> findAll();

    Long addStudent(StudentRequest studentRequest);

}
