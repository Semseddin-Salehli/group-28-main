package az.developia.course.qrup28.web.rest;

import az.developia.course.qrup28.dto.request.UserRequest;
import az.developia.course.qrup28.dto.response.UserResponse;
import az.developia.course.qrup28.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid UserRequest request) {
        userService.createUser(request);
    }

    @PutMapping("/{username}")
    public void update(@RequestBody @Valid UserRequest request, @PathVariable String username) {
        userService.updateUser(request, username);
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

}
