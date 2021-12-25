package az.course.test.service.imp;

import az.course.test.dto.request.StudentRequest;
import az.course.test.dto.response.StudentResponse;

import java.util.List;

public interface Student {
    List<StudentResponse> getStudentList();

    StudentResponse getStudentById(Long id);

    Long addStudent(StudentRequest studentRequest);

    StudentResponse updateStudent(StudentRequest studentRequest, Long studentId);

    StudentResponse deleteStudent(Long id);

}
