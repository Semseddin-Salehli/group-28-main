package az.developia.course.qrup28.web.rest;

import az.developia.course.qrup28.dto.request.TeacherRequest;
import az.developia.course.qrup28.dto.response.TeacherResponse;
import az.developia.course.qrup28.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public List<TeacherResponse> getAll() {
        return teacherService.getAll();
    }

    @PostMapping
    public Long add(@RequestBody TeacherRequest request) {
        return teacherService.add(request);
    }

    @PutMapping("/{id}")
    public TeacherResponse update(@PathVariable Long id, @RequestBody TeacherRequest request) {
        return teacherService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
       return teacherService.delete(id);
    }
}
