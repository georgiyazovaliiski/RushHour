package rushhour.rhproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rushhour.rhproject.entities.Activity;
import rushhour.rhproject.entities.User;
import rushhour.rhproject.entities.UserDto;

@Repository
public interface UserRepository extends BaseRepository<User> {
    User findFirstByEmail(String Email);
}
