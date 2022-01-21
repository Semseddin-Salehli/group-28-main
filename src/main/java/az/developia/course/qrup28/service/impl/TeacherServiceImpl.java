package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.request.TeacherRequest;
import az.developia.course.qrup28.dto.response.TeacherResponse;
import az.developia.course.qrup28.exception.StudentNotFoundException;
import az.developia.course.qrup28.exception.TeacherNotFoundException;
import az.developia.course.qrup28.model.Student;
import az.developia.course.qrup28.model.Teacher;
import az.developia.course.qrup28.repository.StudentRepository;
import az.developia.course.qrup28.repository.TeacherRepository;
import az.developia.course.qrup28.service.TeacherService;
import io.swagger.models.Model;
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
                .map(teacher -> modelMapper.map(teacher , TeacherResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long add(TeacherRequest request) {
        List<Student> teacherStudents = new ArrayList<>();
        for (Long id : request.getStudentIds()) {

            teacherStudents.add(studentRepository.findById(id)
                    .orElseThrow(() -> new StudentNotFoundException("Bele bir telebe tapilmadi" + id)));
        }
        Teacher teacher = modelMapper.map(request , Teacher.class);
        teacher.setStudents(teacherStudents);

        return teacherRepository.save(teacher).getId();
    }

    @Override
    public TeacherResponse update(Long id, TeacherRequest request) {
        List<Student> teacherStudents = new ArrayList<>();

        Teacher dbTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Bele bir muellim tapilmadi"));

        for (Long studentId : request.getStudentIds()) {
            teacherStudents.add(studentRepository.findById(studentId)
                    .orElseThrow(() -> new StudentNotFoundException("Bele bir telebe tapilmadi" + studentId)));
        }
        Teacher newTeacher = modelMapper.map(request , Teacher.class);
        newTeacher.setId(id);
        newTeacher.setStudents(teacherStudents);
        modelMapper.map(newTeacher , dbTeacher);
        teacherRepository.save(dbTeacher);

        return modelMapper.map(dbTeacher , TeacherResponse.class);
    }
}
