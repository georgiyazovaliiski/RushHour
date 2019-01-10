package rushhour.rhproject.modelviews;

import java.time.LocalDate;
import java.util.List;

public class UserViewModel {
    private int Id;

    private String FirstName;

    private String LastName;

    private String email;

    private String Password;

    private String ConfirmedPassword;

    private String Phone;

    private LocalDate DateRegistered;

    private List<AppointmentViewModel> Appointments;

    private List<RoleViewModel> Roles;

    public UserViewModel(int id, String firstName, String lastName, String email, String password, String confirmedPassword, String phone, LocalDate dateRegistered, List<AppointmentViewModel> appointments, List<RoleViewModel> roles) {
        Id = id;
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

    public UserViewModel(int id, String firstName, String lastName, String email, String phone, LocalDate dateRegistered, List<AppointmentViewModel> appointments, List<RoleViewModel> roles) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
        Phone = phone;
        DateRegistered = dateRegistered;
        Appointments = appointments;
        Roles = roles;
    }

    public UserViewModel() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getConfirmedPassword() {
        return ConfirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        ConfirmedPassword = confirmedPassword;
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

    public List<AppointmentViewModel> getAppointments() {
        return Appointments;
    }

    public void setAppointments(List<AppointmentViewModel> appointments) {
        Appointments = appointments;
    }

    public List<RoleViewModel> getRoles() {
        return Roles;
    }

    public void setRoles(List<RoleViewModel> roles) {
        Roles = roles;
    }
}
