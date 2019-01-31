package domain.repository;

import domain.entity.URole;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URoleRepository extends CrudRepository<URole, Long> {

    //@Query("select a.name from URole a, User b where b.username=?1 and a.userid=b.userId")
    //public List<String> findRoleByUserName(String username);

}
