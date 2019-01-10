package rushhour.rhproject.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Role")
public class Role extends BaseEntity{
    private String roleName;

    @ManyToMany(mappedBy = "Roles")
    private Set<User> Users;

    public Role(){

    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return Users;
    }

    public void setUsers(Set<User> users) {
        Users = users;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
