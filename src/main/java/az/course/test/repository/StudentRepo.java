package az.course.test.repository;

import az.course.test.dto.request.StudentRequest;
import az.course.test.dto.response.StudentResponse;
import az.course.test.exception.StudentNotFoundException;
import az.course.test.model.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentRepo {
    private final ModelMapper modelMapper;
    private static List<Student> studentDbTable = new ArrayList<>();
    private static Long virtualId = 1L;

    static {
        studentDbTable.add(new Student(virtualId,
                "Ayan",
                "Esgerova",
                "Baku",
                "0773456578",
                14,
                UUID.randomUUID().toString()));
        virtualId++;
        studentDbTable.add(new Student(virtualId,
                "Semseddin",
                "Salehli",
                "Baku",
                "0773453499",
                14,
                UUID.randomUUID().toString()));
    }

    public List<StudentResponse> getStudents() {
        return studentDbTable.stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
    }

    public StudentResponse getStudentById(Long studentId) {
        return studentDbTable.stream().filter(student -> student.getId().equals(studentId))
                .findFirst()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .orElseThrow(() -> new StudentNotFoundException("Bele bir telebe tapilmadi"));
    }

    public StudentResponse deleteStudent(Long studentId) {
        Student studentModel = studentDbTable.stream().filter(student -> student.getId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Bele bir telebe tapilmadi"));
        studentDbTable.remove(studentModel);
        return modelMapper.map(studentModel, StudentResponse.class);
    }

    public Long addStudent(StudentRequest studentRequest) {
        Student student = modelMapper.map(studentRequest, Student.class);
        virtualId++;
        student.setId(virtualId);
        student.setPrivateColumn(UUID.randomUUID().toString());
        studentDbTable.add(student);
        return virtualId;
    }

    public StudentResponse updateStudent(StudentRequest studentRequest, Long studentId) {
        Student studentDbModel = studentDbTable.stream().filter(student -> student.getId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Bele Telebe tapilmadi"));

        Student newStudent = modelMapper.map(studentRequest, Student.class);
        newStudent.setId(studentDbModel.getId());
        newStudent.setPrivateColumn(studentDbModel.getPrivateColumn());

        studentDbTable.remove(studentDbModel);
        studentDbTable.add(newStudent);

        return modelMapper.map(newStudent, StudentResponse.class);
    }
}
