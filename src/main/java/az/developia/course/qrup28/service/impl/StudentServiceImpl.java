package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.model.Employee;
import az.developia.course.qrup28.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import az.developia.course.qrup28.model.Student;

@Component
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final Student student;

    @Override
    public String getStudentInfo() {
        student.setName("Semseddin");
        student.setSurname("Salehli");
        String name = student.getName();
        String surname = student.getSurname();
        return name.concat(" " + surname);
    }

}
