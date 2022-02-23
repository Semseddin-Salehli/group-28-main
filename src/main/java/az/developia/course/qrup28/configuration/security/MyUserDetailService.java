package az.developia.course.qrup28.configuration.security;

import az.developia.course.qrup28.enums.ExceptionCode;
import az.developia.course.qrup28.exception.NotFoundException;
import az.developia.course.qrup28.model.User;
import az.developia.course.qrup28.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(User.class, username,
                        ExceptionCode.USER_NOT_FOUND.getCode()));
        return new MyUserDetail(user);
    }


}
