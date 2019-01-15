package rushhour.rhproject.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User")
public class User extends BaseEntity {
    private String FirstName;

    private String LastName;

    @Column(unique = true)
    private String email;

    private String Password;

    private String ConfirmedPassword;

    private String Phone;

    private LocalDate DateRegistered;

    @OneToMany(mappedBy = "User", targetEntity = Appointment.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> Appointments;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<Role> Roles;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String confirmedPassword, String phone, LocalDate dateRegistered, List<Appointment> appointments, Set<Role> roles) {
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
        Password = password;
        ConfirmedPassword = confirmedPassword;
        Phone = phone;
        DateRegistered = dateRegistered;
        Appointments = appointments;
        Roles = roles;
    }

    public String getConfirmedPassword() {
        return ConfirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        ConfirmedPassword = confirmedPassword;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public LocalDate getDateRegistered() {
        return DateRegistered;
    }

    public void setDateRegistered(LocalDate dateRegistered) {
        DateRegistered = dateRegistered;
    }

    public List<Appointment> getAppointments() {
        return Appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        Appointments = appointments;
    }

    public Set<Role> getRoles() {
        return Roles;
    }

    public void setRoles(Set<Role> roles) {
        Roles = roles;
    }
}
