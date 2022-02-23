package az.developia.course.qrup28.service;

import az.developia.course.qrup28.dto.request.UserRequest;

public interface UserService {
    void createUser(UserRequest userRequest);
    void updateUser(UserRequest userRequest, String username);
}
