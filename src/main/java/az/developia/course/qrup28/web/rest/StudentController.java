package az.developia.course.qrup28.web.rest;


import az.developia.course.qrup28.dto.request.StudentRequest;
import az.developia.course.qrup28.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import az.developia.course.qrup28.dto.response.StudentResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
