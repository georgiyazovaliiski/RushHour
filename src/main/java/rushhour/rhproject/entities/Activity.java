package rushhour.rhproject.entities;

import javax.persistence.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Activity")
public class Activity extends BaseEntity{
    private String Name;

    private Duration Duration;

    private Double Price;

    @ManyToMany(mappedBy = "Activities")
    private Set<Appointment> Appointments = new HashSet<>();

    public Activity(){

    }

    public Activity(String name, java.time.Duration duration, Double price) {
        Name = name;
        Duration = duration;
        Price = price;
    }

    public Activity(String name, java.time.Duration duration, Double price, Set<Appointment> appointments) {
        Name = name;
        Duration = duration;
        Price = price;
        Appointments = appointments;
    }

    public Activity(String name) {
        Name = name;
        Appointments = new HashSet<>();
    }

    public Activity(String name, Set<Appointment> appointments) {
        Name = name;
        Appointments = appointments;
    }

    public java.time.Duration getDuration() {
        return Duration;
    }

    public void setDuration(java.time.Duration duration) {
        Duration = duration;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Set<Appointment> getAppointments() {
        return Appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        Appointments = appointments;
    }
}
