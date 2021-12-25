package az.course.test.service;


import az.course.test.dto.request.StudentRequest;
import az.course.test.dto.response.StudentResponse;
import az.course.test.repository.StudentRepo;
import az.course.test.service.imp.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements Student {
    private final StudentRepo repo;

    @Override
    public List<StudentResponse> getStudentList() {
        return repo.getStudents();
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        System.out.println("GetStudentById servisi cagirildi");
        return repo.getStudentById(id);
    }

    @Override
    public Long addStudent(StudentRequest studentRequest) {
        System.out.println("AddStudent servisi cagirildi");
        return repo.addStudent(studentRequest);
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Long studentId) {
        System.out.println("Update metodu cagirildi");
        return repo.updateStudent(studentRequest, studentId);
    }

    @Override
    public StudentResponse deleteStudent(@PathVariable("id") Long id) {
        System.out.println("Delete methodu cagirildi");
        return repo.deleteStudent(id);
    }
}
