package az.developia.course.qrup28.service;

import az.developia.course.qrup28.dto.response.feign.OtherUser;

import java.util.List;

public interface OtherUsersService {
    List<OtherUser> getAllUsers();
}
