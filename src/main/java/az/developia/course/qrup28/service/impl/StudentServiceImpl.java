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
    public List<StudentResponse> getAllByClassId(Long classId) {
        SchoolClass dbClass = classRepository.findById(classId)
                .orElseThrow(() -> new NotFoundException(SchoolClass.class, classId,
                        ExceptionCode.STUDENT_CLASS_NOT_FOUND.getCode()));

        return studentRepository.findAllBySchoolClass(dbClass).stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
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

        Series dbSeries = dbStudent.getSeries();
        modelMapper.map(studentRequest.getSeries(), dbSeries);

        Student newStudent = Student.builder()
                .id(studentId)
                .name(studentRequest.getName())
                .surname(studentRequest.getSurname())
                .phone(studentRequest.getPhone())
                .address(studentRequest.getAddress())
                .age(studentRequest.getAge())
                .series(dbSeries)
                .schoolClass(schoolClass)
                .build();


        return modelMapper.map(studentRepository.save(newStudent), StudentResponse.class);
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
