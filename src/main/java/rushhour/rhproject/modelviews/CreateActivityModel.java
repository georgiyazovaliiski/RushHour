package rushhour.rhproject.modelviews;

import java.util.List;

public class CreateActivityModel {
    private String Name;
    private String Duration;
    private Double Price;
    private List<CreateAppointmentModel> Appointments;

    public CreateActivityModel(){

    }

    public CreateActivityModel(String name, String duration, Double price, List<CreateAppointmentModel> appointmentModelList) {
        Name = name;
        Duration = duration;
        Price = price;
        this.Appointments = appointmentModelList;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public List<CreateAppointmentModel> getAppointments() {
        return Appointments;
    }

    public void setAppointments(List<CreateAppointmentModel> appointments) {
        this.Appointments = appointments;
    }
}
