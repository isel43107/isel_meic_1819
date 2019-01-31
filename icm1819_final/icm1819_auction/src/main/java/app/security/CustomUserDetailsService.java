package app.security;

import domain.entity.UPermission;
import domain.entity.URole;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.entity.User;
import domain.repository.UserRepository;
import domain.repository.URoleRepository;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final URoleRepository userRolesRepository;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository,
            URoleRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {

        try {
            final User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("Cannot found user with this username: " + email);
            }

            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(), user.getPassword(), user.isEnabled(), 
                    true, true, true, 
                    getAuthorities(user.getRoles()));
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            final Collection<URole> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(final Collection<URole> roles) {
        final List<String> privileges = new ArrayList<>();
        final List<UPermission> collection = new ArrayList<>();
        roles.forEach((role) -> {
            collection.addAll(role.getPermissions());
        });
        collection.forEach((item) -> {
            privileges.add(item.getName());
        });

        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(final List<String> permissions) {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        permissions.forEach((permi) -> {
            authorities.add(new SimpleGrantedAuthority(permi));
        });
        return authorities;
    }

    public User loadUserByUsername1(String username) throws Exception {
        User user = userRepository.findByUsername(username);
        if (null == user) {
            throw new Exception("Cannot found user with this username: " + username);
        } else {
            // List<String> userRoles = userRolesRepository.findRoleByUserName(username);
            //return new CustomUserDetails(user, userRoles);
        }
        return null;
    }

    /*  */
    org.springframework.security.crypto.password.PasswordEncoder encoder
            = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();

    /**
     * Check if password match to a hash password
     *
     * @param passsword clear text password
     * @param hashPasssword hashed password
     * @return
     * @throws Exception
     */
    public boolean checkPassword(String passsword, String hashPasssword) throws Exception {

        boolean passMatch = false;

        if (passsword == null || hashPasssword == null) {
            throw new Exception("Passsword or hashPasssword cannot be null");
        } else {
            passMatch = encoder.matches(passsword, hashPasssword);
        }

        return passMatch;
    }

    /**
     * Encode a clear password with a security encoding/hashing algorithm
     *
     * @param passsword to generate hash
     * @return hashing password
     * @throws Exception
     */
    public String encodePassword(String passsword) throws Exception {

        if (null == passsword) {
            throw new Exception("Password cannot be null");
        } else {
            return encoder.encode(passsword);
        }
    }

    private final String getClientIP() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

}
