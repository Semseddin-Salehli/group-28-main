package az.developia.course.qrup28.service;

import az.developia.course.qrup28.dto.request.StudentRequest;
import az.developia.course.qrup28.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
     List<StudentResponse> getStudentList();

     StudentResponse getStudentById(Long id);

     Long addStudent(StudentRequest studentRequest);

     StudentResponse updateStudent(StudentRequest studentRequest, Long studentId);

     StudentResponse deleteStudent(Long id);
}
