package az.developia.course.qrup28.service.impl;

import az.developia.course.qrup28.dto.request.UserRequest;
import az.developia.course.qrup28.dto.response.UserResponse;
import az.developia.course.qrup28.enums.ExceptionCode;
import az.developia.course.qrup28.exception.NotFoundException;
import az.developia.course.qrup28.model.User;
import az.developia.course.qrup28.repository.UserRepository;
import az.developia.course.qrup28.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

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

    @Override
    public List<UserResponse> getAll() {
        return repository.findAll().stream()
                .map(users -> modelMapper.map(users, UserResponse.class))
                .collect(Collectors.toList());
    }
}
