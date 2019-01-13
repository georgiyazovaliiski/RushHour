package rushhour.rhproject.modelviews;

import java.util.Set;

public class CreateAppointmentModel {
    private String Name;
    private String StartDate;
    private String EndDate;
    private Set<CreateActivityModel> Activities;

    public CreateAppointmentModel() {
    }

    public CreateAppointmentModel(String name, String startDate, String endDate) {
        Name = name;
        StartDate = startDate;
        EndDate = endDate;
    }

    public CreateAppointmentModel(String name, String startDate, String endDate, Set<CreateActivityModel> activities) {
        Name = name;
        StartDate = startDate;
        EndDate = endDate;
        Activities = activities;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public Set<CreateActivityModel> getActivities() {
        return Activities;
    }

    public void setActivities(Set<CreateActivityModel> activities) {
        Activities = activities;
    }
}
