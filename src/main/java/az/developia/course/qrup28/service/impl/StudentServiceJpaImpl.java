package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.request.StudentRequest;
import az.developia.course.qrup28.dto.response.StudentResponse;
import az.developia.course.qrup28.exception.StudentNotFoundException;
import az.developia.course.qrup28.model.Student;
import az.developia.course.qrup28.repository.StudentRepository;
import az.developia.course.qrup28.service.StudentServiceJpa;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceJpaImpl implements StudentServiceJpa {
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

    @Override
    public StudentResponse getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .orElseThrow(() -> new StudentNotFoundException("Bele bir telebe tapilmadi."));
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Long studentId) {
        Student dbStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Bele bir telebe tapilmadi."));
        modelMapper.map(studentRequest, dbStudent);
        studentRepository.save(dbStudent);
        return modelMapper.map(dbStudent, StudentResponse.class);
    }

    @Override
    public StudentResponse deleteStudent(Long studentId) {
        Student dbStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Bele bir telebe tapilmadi."));
        studentRepository.delete(dbStudent);
        return modelMapper.map(dbStudent, StudentResponse.class);
    }

}
