package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.response.feign.OtherUser;
import az.developia.course.qrup28.feign.client.OtherUserFeign;
import az.developia.course.qrup28.service.OtherUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OtherUsersServiceImpl implements OtherUsersService {

    private final OtherUserFeign feign;

    @Override
    public List<OtherUser> getAllUsers() {
        return feign.getAllUser();
    }
}
