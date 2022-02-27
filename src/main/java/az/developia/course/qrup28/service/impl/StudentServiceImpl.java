package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.request.StudentRequest;
import az.developia.course.qrup28.dto.response.StudentResponse;
import az.developia.course.qrup28.enums.ExceptionCode;
import az.developia.course.qrup28.exception.NotFoundException;
import az.developia.course.qrup28.model.SchoolClass;
import az.developia.course.qrup28.model.Series;
import az.developia.course.qrup28.model.Student;
import az.developia.course.qrup28.repository.SchoolClassRepository;
import az.developia.course.qrup28.repository.StudentRepository;
import az.developia.course.qrup28.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final SchoolClassRepository classRepository;

    @Override
    public List<StudentResponse> getAll() {
        return studentRepository.findAll().stream().map(student -> modelMapper
                .map(student, StudentResponse.class)).collect(Collectors.toList());
    }

    @Override
    public Long add(StudentRequest studentRequest) {
        SchoolClass schoolClass = classRepository.findById(studentRequest.getSchoolClassId())
                .orElseThrow(() -> new NotFoundException(SchoolClass.class, studentRequest.getSchoolClassId(),
                        ExceptionCode.STUDENT_NOT_FOUND_EXCEPTION.getCode()));
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(StudentRequest.class, Student.class).addMappings(mp -> {
            mp.skip(Student::setId);
        });

        Student newStudent = modelMapper.map(studentRequest, Student.class);
        newStudent.setSchoolClass(schoolClass);

        return studentRepository.save(newStudent).getId();
    }

    @Override
    public StudentResponse getById(Long id) {
        return studentRepository.findById(id)
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .orElseThrow(() -> new NotFoundException(Student.class, id,
                        ExceptionCode.STUDENT_NOT_FOUND_EXCEPTION.getCode()));
    }

    @Override
    public StudentResponse update(StudentRequest studentRequest, Long studentId) {
        SchoolClass schoolClass = classRepository.findById(studentRequest.getSchoolClassId())
                .orElseThrow(() -> new NotFoundException(SchoolClass.class, studentRequest.getSchoolClassId(),
                        ExceptionCode.STUDENT_CLASS_NOT_FOUND.getCode()));

        Student dbStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException(Student.class, studentId,
                        ExceptionCode.STUDENT_NOT_FOUND_EXCEPTION.getCode()));

        Student newStudent = modelMapper.map(studentRequest, Student.class);

        Series dbSeries = dbStudent.getSeries();
        modelMapper.map(studentRequest.getSeries(), dbSeries);

        newStudent.setSeries(dbSeries);
        newStudent.setId(studentId);
        newStudent.setSchoolClass(schoolClass);
        modelMapper.map(newStudent, dbStudent);

        studentRepository.save(dbStudent);

        return modelMapper.map(dbStudent, StudentResponse.class);
    }

    @Override
    public StudentResponse delete(Long studentId) {
        Student dbStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException(Student.class, studentId,
                        ExceptionCode.STUDENT_NOT_FOUND_EXCEPTION.getCode()));
        studentRepository.delete(dbStudent);
        return modelMapper.map(dbStudent, StudentResponse.class);
    }

}
