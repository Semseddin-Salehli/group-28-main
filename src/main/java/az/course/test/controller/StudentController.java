package az.course.test.controller;

import az.course.test.dto.request.StudentRequest;
import az.course.test.dto.response.StudentResponse;
import az.course.test.service.StudentService2;
import az.course.test.service.imp.StudentServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImp studentService;
    private final StudentService2 service2;

    @GetMapping
    public List<StudentResponse> getStudentList() {
//        return studentService.getStudentList();
        return service2.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable("id") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @DeleteMapping("/{studentId}")
    public StudentResponse deleteStudent(@PathVariable("studentId") Long id) {
        return studentService.deleteStudent(id);
    }

    @PostMapping()
    public Long addStudent(@RequestBody StudentRequest studentRequest) {
//        return studentService.addStudent(studentRequest);
        return service2.addStudent(studentRequest);
    }

    @PutMapping()
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest, @RequestParam("id") Long studentId) {
        return studentService.updateStudent(studentRequest, studentId);
    }
}
