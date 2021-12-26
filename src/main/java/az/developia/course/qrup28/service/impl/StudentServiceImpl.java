package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.request.StudentRequest;
import az.developia.course.qrup28.dto.response.StudentResponse;
import az.developia.course.qrup28.repository.StudentRepo;
import az.developia.course.qrup28.repository.StudentRepository;
import az.developia.course.qrup28.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import az.developia.course.qrup28.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo repo;

    @Override
    public List<StudentResponse> getStudentList() {
        return repo.getStudents();
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return repo.getStudentById(id);
    }

    @Override
    public Long addStudent(StudentRequest studentRequest) {
        return repo.addStudent(studentRequest);
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Long studentId) {
        return repo.updateStudent(studentRequest, studentId);
    }

    @Override
    public StudentResponse deleteStudent(@PathVariable("id") Long id) {
        return repo.deleteStudent(id);
    }
}
