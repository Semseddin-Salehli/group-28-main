package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.request.UserRequest;
import az.developia.course.qrup28.enums.ExceptionCode;
import az.developia.course.qrup28.exception.NotFoundException;
import az.developia.course.qrup28.model.User;
import az.developia.course.qrup28.repository.UserRepository;
import az.developia.course.qrup28.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserRequest userRequest) {
        repository.save(User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .roles(userRequest.getRoles())
                .build());
    }

    @Override
    public void updateUser(UserRequest userRequest, String username) {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(User.class, username,
                        ExceptionCode.USER_NOT_FOUND.getCode()));

        repository.save(User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .roles(userRequest.getRoles())
                .id(user.getId())
                .build());
    }
}
