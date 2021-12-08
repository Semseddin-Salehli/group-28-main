package az.developia.course.qrup28.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class Controller {

    private final Service service;

    @GetMapping
    public String getStudent() {
        return service.getStudentInfo();
    }

}
