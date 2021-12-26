package az.course.test.service.imp;

import az.course.test.dto.request.StudentRequest;
import az.course.test.dto.response.StudentResponse;
import az.course.test.model.Student;
import az.course.test.repository.StudentRepository;
import az.course.test.service.StudentService2;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImp2 implements StudentService2 {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream().map(student -> modelMapper
                .map(student, StudentResponse.class)).collect(Collectors.toList());
    }

    @Override
    public Long addStudent(StudentRequest studentRequest) {
        Student save = studentRepository.save(modelMapper.map(studentRequest, Student.class));
        return save.getId();
    }
}
