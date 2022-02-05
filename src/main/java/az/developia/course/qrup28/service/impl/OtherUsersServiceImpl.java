package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.response.feign.OtherUser;
import az.developia.course.qrup28.feign.client.OtherUserFeign;
import az.developia.course.qrup28.service.OtherUsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OtherUsersServiceImpl implements OtherUsersService {

    private final OtherUserFeign feign;
    private final ObjectMapper objectMapper;

    @Override
    public String getAllUsers() {
        try {
            List<OtherUser> allUser = feign.getAllUser();
            return objectMapper.writeValueAsString(allUser);
        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
