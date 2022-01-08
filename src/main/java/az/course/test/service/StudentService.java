package az.course.test.service;

import az.course.test.dto.request.StudentRequest;
import az.course.test.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> findAll();

    Long addStudent(StudentRequest studentRequest);

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(StudentRequest studentRequest, Long studentId);

    StudentResponse deleteStudent(Long studentId);
}
