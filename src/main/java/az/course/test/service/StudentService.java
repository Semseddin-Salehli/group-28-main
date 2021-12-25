package az.course.test.service;

import az.course.test.dto.request.StudentRequest;
import az.course.test.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getStudentList();

    StudentResponse getStudentById(Long id);

    Long addStudent(StudentRequest studentRequest);

    StudentResponse updateStudent(StudentRequest studentRequest, Long studentId);

    StudentResponse deleteStudent(Long id);

}
