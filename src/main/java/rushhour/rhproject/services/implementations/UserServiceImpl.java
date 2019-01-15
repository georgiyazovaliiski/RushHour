package rushhour.rhproject.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rushhour.rhproject.JWTSecurity.models.RegisterRequest;
import rushhour.rhproject.entities.Role;
import rushhour.rhproject.entities.User;
import rushhour.rhproject.entities.UserDto;
import rushhour.rhproject.repositories.BaseRepository;
import rushhour.rhproject.repositories.RoleRepository;
import rushhour.rhproject.repositories.UserRepository;
import rushhour.rhproject.services.interfaces.UserService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl extends CrudServiceImpl<User> implements UserService {
    private RoleRepository roleRepository;

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(BaseRepository<User> baseRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(baseRepository);
        this.userRepository = (UserRepository)baseRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User saveUser(RegisterRequest registerRequest) {
        super.baseRepository.findAll();

        if (emailExist(registerRequest.getEmail())) {
            return null;
        }
        Set<Role> roles = new HashSet<Role>();
        Role roleUser = roleRepository.findFirstByRoleName("ROLE_USER");
        Role roleAdmin = roleRepository.findFirstByRoleName("ROLE_ADMIN");

        roles.add(roleUser);
        //roles.add(roleAdmin);

        User user = new User(
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getEmail(),
                bCryptPasswordEncoder.encode(registerRequest.getPassword()),
                bCryptPasswordEncoder.encode(registerRequest.getPassword()),
                "",
                LocalDate.now(),
                new ArrayList<>(),
                roles
        );



        super.baseRepository.save(user);
        return user;
    }

    @Override
    public User registerNewUserAccount(UserDto accountDto){

        super.baseRepository.findAll();

        if (emailExist(accountDto.getEmail())) {
            return null;
        }
        Set<Role> roles = new HashSet<Role>();
        Role roleUser = roleRepository.findFirstByRoleName("ROLE_USER");
        Role roleAdmin = roleRepository.findFirstByRoleName("ROLE_ADMIN");

        roles.add(roleUser);
        //roles.add(roleAdmin);

        User user = new User(
                accountDto.getFirstName(),
                accountDto.getLastName(),
                accountDto.getEmail(),
                bCryptPasswordEncoder.encode(accountDto.getPassword()),
                bCryptPasswordEncoder.encode(accountDto.getMatchingPassword()),
                "",
                LocalDate.now(),
                new ArrayList<>(),
                roles
        );



        super.baseRepository.save(user);

        return user;
        // the rest of the registration operation
    }

    @Override
    public boolean ifUserExists(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(int Id) {
        Optional<User> user = userRepository.findById(Id);
        System.out.println("SHITNQ: " + user.get().getFirstName());
        return userRepository.findById(Id);
    }

    private boolean emailExist(String email) {
        System.out.println("RANDOM NADPIS2: " + email);
        User user = userRepository.findFirstByEmail(email);

        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    void preInsert(User entity) {

    }

    @Override
    void postInsert(User entity) {

    }

    @Override
    public void save(User entity) {
        userRepository.save(entity);
    }

    @Override
    public Iterable<User> getAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(int Id) {

    }

    @Override
    public boolean ifExists(User Entity) {
        return false;
    }
}