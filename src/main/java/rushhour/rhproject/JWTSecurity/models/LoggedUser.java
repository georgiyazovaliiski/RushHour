package rushhour.rhproject.JWTSecurity.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rushhour.rhproject.entities.User;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LoggedUser implements UserDetails {
    private Integer id;

    private String email;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public LoggedUser(){

        }

    public LoggedUser(Integer id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
            this.id = id;
            this.email = email;
            this.password = password;
        this.authorities = authorities;
    }

    public static LoggedUser create(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName())
        ).collect(Collectors.toList());

        return new LoggedUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    public Integer getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoggedUser that = (LoggedUser) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}