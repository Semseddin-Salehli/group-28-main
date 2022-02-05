package az.developia.course.qrup28.web.rest;

import az.developia.course.qrup28.service.OtherUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otherUsers")
@RequiredArgsConstructor
public class OtherUserController {

    private final OtherUsersService usersService;

    @GetMapping
    public String getUsers() {
        return usersService.getAllUsers();
    }
}
