package az.course.test.controller;

import az.course.test.dto.request.StudentRequest;
import az.course.test.dto.response.StudentResponse;
import az.course.test.service.imp.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImpl studentServiceImpl;

    @GetMapping
    public List<StudentResponse> getStudentList() {
        return studentServiceImpl.getStudentList();
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
        return studentServiceImpl.addStudent(studentRequest);
    }

    @PutMapping()
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest, @RequestParam("id") Long studentId) {
        return studentServiceImpl.updateStudent(studentRequest, studentId);
    }
}
