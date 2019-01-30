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
    
    /*
        org.springframework.security.crypto.password.PasswordEncoder encoder
= new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    */
    /**
     * Check if password match to a hash password
     * @param passs
     * @param hassPass
     * @return
     * @throws Exception 
     */
    /*
    public boolean checkPassword(String passs, String hassPass) throws Exception {
        
        boolean passMatch = false;

        if (passs == null || hassPass == null ) {
            throw new Exception("Cannot be null passs or  hassPass");
        } else {
            passMatch = encoder.matches(passs, hassPass);
        }
        
        return passMatch;
    }*
    
    /**
     * Encode a clear password with a security encoding/hashing algorithm
     * 
     * @param passs
     * @return hashing password
     * @throws Exception 
     */
    /*
    public String encodePassword(String passs) throws Exception {
        
        if (null == passs) {
            throw new Exception("Canot be passs");
        } else {
            return encoder.encode(passs);
        }
    }
    */
  
}
