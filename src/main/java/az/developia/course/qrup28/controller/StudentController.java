package az.developia.course.qrup28.controller;


import az.developia.course.qrup28.dto.request.StudentRequest;
import az.developia.course.qrup28.service.StudentServiceJpa;
import az.developia.course.qrup28.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import az.developia.course.qrup28.dto.response.StudentResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;
    private final StudentServiceJpa studentServiceJpa;

    @GetMapping
    public List<StudentResponse> getStudentList() {
        return studentServiceJpa.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable("id") Long studentId) {
        return studentServiceImpl.getStudentById(studentId);
    }

    @DeleteMapping("/{studentId}")
    public StudentResponse deleteStudent(@PathVariable("studentId") Long id) {
        return studentServiceImpl.deleteStudent(id);
    }

    @PostMapping()
    public Long addStudent(@RequestBody StudentRequest studentRequest) {
        return studentServiceJpa.addStudent(studentRequest);
    }

    @PutMapping()
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest, @RequestParam("id") Long studentId) {
        return studentServiceImpl.updateStudent(studentRequest, studentId);
    }
}
