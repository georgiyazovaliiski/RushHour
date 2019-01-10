package rushhour.rhproject.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Appointment")
public class Appointment  extends BaseEntity{
    private String Name;

    private Instant StartDate;

    private Instant EndDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "Id")
    private User User;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "appointments_activities",
            joinColumns = { @JoinColumn(name = "appointment_id") },
            inverseJoinColumns = { @JoinColumn(name = "activity_id") }
    )
    private Set<Activity> Activities = new HashSet<>();

    public Appointment(){

    }

    public Appointment(String name, Instant startDate, Instant endDate, User user, Set<Activity> activities) {
        Name = name;
        StartDate = startDate;
        EndDate = endDate;
        User = user;
        Activities = activities;
    }

    public Instant getStartDate() {
        return StartDate;
    }

    public void setStartDate(Instant startDate) {
        StartDate = startDate;
    }

    public Instant getEndDate() {
        return EndDate;
    }

    public void setEndDate(Instant endDate) {
        EndDate = endDate;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public Set<Activity> getActivities() {
        return Activities;
    }

    public void setActivities(Set<Activity> activities) {
        Activities = activities;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
