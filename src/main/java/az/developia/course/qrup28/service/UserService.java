package az.developia.course.qrup28.service;

import az.developia.course.qrup28.dto.request.UserRequest;
import az.developia.course.qrup28.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    void createUser(UserRequest userRequest);

    void updateUser(UserRequest userRequest, String username);

    List<UserResponse> getAll();
}
