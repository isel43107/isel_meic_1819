package security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.entity.User;
import domain.repository.UserRepository;
import domain.repository.UserRolesRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService {

    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
    }


    public User loadUserByUsername(String username) throws Exception {
        User user = userRepository.findByUserName(username);
        if (null == user) {
            throw new Exception("No user present with username: " + username);
        } else {
            List<String> userRoles = userRolesRepository.findRoleByUserName(username);
            return new CustomUserDetails(user, userRoles);
        }
    }

}
