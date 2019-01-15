package rushhour.rhproject.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rushhour.rhproject.JWTSecurity.models.LoggedUser;
import rushhour.rhproject.entities.User;
import rushhour.rhproject.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found.");
        }

        Set<SimpleGrantedAuthority> roles = user.getRoles().stream().map(r->new SimpleGrantedAuthority(r.getRoleName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                roles
        );
    }


    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return LoggedUser.create(user);
    }
}
