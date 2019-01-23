package domain.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id")
    private Long userroleid;

    @Column(name = "userid")
    private Long userid;

    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(Long userroleid) {
        this.userroleid = userroleid;
    }

    
    public static enum Roles {
        
        USER("USER"),
        SYSTEM_USER("SYSTEM_USER"),
        SYSTEM_ADMIN("SYSTEM_ADMIN"),
        COMPANY_USER("COMPANY_USER"),
        COMPANY_ADMIN("COMPANY_ADMIN");

        private String role;

        Roles(String role) {
            this.role = role;
        }

        public String getRole() {
            return role;
        }
        
        @Override
        public String toString(){
            return role;
        }
    }
}
