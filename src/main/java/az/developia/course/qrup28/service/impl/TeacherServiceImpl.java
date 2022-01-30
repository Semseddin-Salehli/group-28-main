package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.request.TeacherRequest;
import az.developia.course.qrup28.dto.response.TeacherResponse;
import az.developia.course.qrup28.enums.ExceptionCode;
import az.developia.course.qrup28.exception.NotFoundException;
import az.developia.course.qrup28.model.Student;
import az.developia.course.qrup28.model.Teacher;
import az.developia.course.qrup28.repository.StudentRepository;
import az.developia.course.qrup28.repository.TeacherRepository;
import az.developia.course.qrup28.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;

    @Override
    public List<TeacherResponse> getAll() {
        return teacherRepository.findAll().stream()
                .map(teacher -> modelMapper.map(teacher, TeacherResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long add(TeacherRequest request) {
        List<Student> teacherStudents = new ArrayList<>();

        request.getStudentIds().forEach(id ->
                teacherStudents.add(studentRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(Student.class,
                                id,
                                ExceptionCode.STUDENT_NOT_FOUND_EXCEPTION.getCode()))));


        Teacher teacher = modelMapper.map(request, Teacher.class);
        teacher.setStudents(teacherStudents);

        return teacherRepository.save(teacher).getId();
    }

    @Override
    public TeacherResponse update(Long id, TeacherRequest request) {
        List<Student> teacherStudents = new ArrayList<>();

        teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Teacher.class, id,
                        ExceptionCode.TEACHER_CLASS_NOT_FOUND.getCode()));

        request.getStudentIds().forEach(studentId ->
                teacherStudents.add(studentRepository.findById(studentId)
                        .orElseThrow(() -> new NotFoundException(Student.class,
                                studentId,
                                ExceptionCode.STUDENT_NOT_FOUND_EXCEPTION.getCode()))));
        Teacher newTeacher = Teacher.builder()
                .id(id)
                .name(request.getName())
                .surname(request.getSurname())
                .students(teacherStudents)
                .build();
        teacherRepository.save(newTeacher);

        return modelMapper.map(newTeacher, TeacherResponse.class);
    }

    @Override
    public Long delete(Long id) {
        Teacher dbTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Teacher.class, id,
                        ExceptionCode.TEACHER_CLASS_NOT_FOUND.getCode()));
        teacherRepository.delete(dbTeacher);
        return dbTeacher.getId();
    }


}
