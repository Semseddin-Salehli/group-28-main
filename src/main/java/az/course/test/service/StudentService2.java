package az.course.test.service;

import az.course.test.dto.request.StudentRequest;
import az.course.test.dto.response.StudentResponse;

import java.util.List;

public interface StudentService2 {
    List<StudentResponse> findAll();

    Long addStudent(StudentRequest studentRequest);
}
