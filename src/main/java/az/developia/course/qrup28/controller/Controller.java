package az.developia.course.qrup28.controller;

import az.developia.course.qrup28.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class Controller {

    @Autowired
    private StudentService service;

    @GetMapping
    public String getStudent() {
        return service.getStudentInfo();
    }

}
