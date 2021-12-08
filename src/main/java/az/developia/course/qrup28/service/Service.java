package az.developia.course.qrup28.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import az.developia.course.qrup28.model.Student;

@Component
@RequiredArgsConstructor
public class Service {

    private final Student student;



    public String getStudentInfo() {
        student.setName("Semseddin");
        student.setSurname("Salehli");
        String name = student.getName();
        String surname = student.getSurname();
        return name.concat(" " + surname);
    }

}
