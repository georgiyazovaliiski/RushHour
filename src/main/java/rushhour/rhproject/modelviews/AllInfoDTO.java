package rushhour.rhproject.modelviews;

public class AllInfoDTO {
    private ActivityViewModel activityViewModel;
    private AppointmentViewModel appointmentViewModel;
    private RoleViewModel roleViewModel;
    private UserViewModel userViewModel;

    public AllInfoDTO(ActivityViewModel activityViewModel, AppointmentViewModel appointmentViewModel, RoleViewModel roleViewModel, UserViewModel userViewModel) {
        this.activityViewModel = activityViewModel;
        this.appointmentViewModel = appointmentViewModel;
        this.roleViewModel = roleViewModel;
        this.userViewModel = userViewModel;
    }

    public AllInfoDTO() {
    }

    public ActivityViewModel getActivityViewModel() {
        return activityViewModel;
    }

    public void setActivityViewModel(ActivityViewModel activityViewModel) {
        this.activityViewModel = activityViewModel;
    }

    public AppointmentViewModel getAppointmentViewModel() {
        return appointmentViewModel;
    }

    public void setAppointmentViewModel(AppointmentViewModel appointmentViewModel) {
        this.appointmentViewModel = appointmentViewModel;
    }

    public RoleViewModel getRoleViewModel() {
        return roleViewModel;
    }

    public void setRoleViewModel(RoleViewModel roleViewModel) {
        this.roleViewModel = roleViewModel;
    }

    public UserViewModel getUserViewModel() {
        return userViewModel;
    }

    public void setUserViewModel(UserViewModel userViewModel) {
        this.userViewModel = userViewModel;
    }
}
