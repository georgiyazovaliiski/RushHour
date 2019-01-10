package rushhour.rhproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rushhour.rhproject.entities.Activity;
import rushhour.rhproject.entities.Role;

@Repository
public interface RoleRepository extends BaseRepository<Role> {
    Role findFirstByRoleName(String rolename);
}
