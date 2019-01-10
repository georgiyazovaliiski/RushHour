package rushhour.rhproject.modelviews;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ActivityViewModel {
    private int Id;
    private String Name;

    private java.time.Duration Duration;

    private Double Price;

    private List<AppointmentViewModel> Appointments = new ArrayList<>();

    public ActivityViewModel(int id, String name, java.time.Duration duration, Double price, List<AppointmentViewModel> appointments) {
        Id = id;
        Name = name;
        Duration = duration;
        Price = price;
        Appointments = appointments;
    }

    public ActivityViewModel() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public List<AppointmentViewModel> getAppointments() {
        return Appointments;
    }

    public void setAppointments(List<AppointmentViewModel> appointments) {
        Appointments = appointments;
    }
}
