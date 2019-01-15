package rushhour.rhproject.services.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import rushhour.rhproject.JWTSecurity.models.RegisterRequest;
import rushhour.rhproject.entities.User;
import rushhour.rhproject.entities.UserDto;

import java.util.Optional;

public interface UserService extends CrudService<User> {
    User registerNewUserAccount(UserDto accountDto);
    boolean ifUserExists(String email);
    User findByEmail(String email);
    Iterable<User> getAllUsers();
    Optional<User> getById(int Id);
    void save(User user);
    User saveUser(RegisterRequest user);
}
