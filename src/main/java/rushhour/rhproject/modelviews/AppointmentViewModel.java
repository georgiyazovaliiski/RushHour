package rushhour.rhproject.modelviews;

import java.time.Instant;
import java.util.List;

public class AppointmentViewModel {
    private int Id;

    private String Name;

    private Instant StartDate;

    private Instant EndDate;

    private int UserId;

    private List<ActivityViewModel> Activites;

    public AppointmentViewModel(){

    }

    public AppointmentViewModel(int id, String name, Instant startDate, Instant endDate, int userId, List<ActivityViewModel> activites) {
        Id = id;
        Name = name;
        StartDate = startDate;
        EndDate = endDate;
        UserId = userId;
        Activites = activites;
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

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public List<ActivityViewModel> getActivites() {
        return Activites;
    }

    public void setActivites(List<ActivityViewModel> activites) {
        Activites = activites;
    }
}
