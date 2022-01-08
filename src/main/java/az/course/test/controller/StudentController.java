package az.course.test.controller;

import az.course.test.dto.request.StudentRequest;
import az.course.test.dto.response.StudentResponse;
import az.course.test.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentResponse> getStudentList() {
        return studentService.findAll();
    }

    @PostMapping()
    public Long addStudent(@RequestBody @Valid StudentRequest studentRequest) {
        return studentService.addStudent(studentRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable @Min(value = 0, message = "id 0-dan boyuk olmalidir") Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping
    public StudentResponse updateStudent(@RequestBody @Valid StudentRequest studentRequest, @RequestParam @Min(value = 0) Long studentId) {
        return studentService.updateStudent(studentRequest, studentId);
    }

    @DeleteMapping("/{studentId}")
    public StudentResponse deleteStudent(@PathVariable @Min(value = 0) Long studentId) {
        return studentService.deleteStudent(studentId);
    }
}
