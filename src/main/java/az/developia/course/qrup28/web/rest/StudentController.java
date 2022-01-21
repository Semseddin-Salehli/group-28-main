package az.developia.course.qrup28.web.rest;


import az.developia.course.qrup28.dto.request.StudentRequest;
import az.developia.course.qrup28.repository.StudentRepository;
import az.developia.course.qrup28.service.StudentServiceJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import az.developia.course.qrup28.dto.response.StudentResponse;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/student")
public class StudentController {
    private final StudentServiceJpa studentService;
    private final StudentRepository repository;

    @GetMapping
    public List<StudentResponse> getStudentList() {
        return studentService.findAll();
    }

    @PostMapping()
    public Long addStudent(@RequestBody @Valid StudentRequest studentRequest) {
        return studentService.addStudent(studentRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable @Min(value = 0, message = "İd 0 dan böyük olmalıdır") Long id) {
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
