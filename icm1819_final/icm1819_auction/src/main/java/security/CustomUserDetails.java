package security;

import java.util.Collection;
import java.util.List;
import org.springframework.util.StringUtils;
import domain.entity.User;

public class CustomUserDetails extends domain.entity.User {

    private static final long serialVersionUID = 1L;
    private final List<String> userRoles;

    public CustomUserDetails(User user, List<String> userRoles) {
        super(user);
        this.userRoles = userRoles;
    }

}
