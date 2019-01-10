package rushhour.rhproject.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rushhour.rhproject.entities.Activity;
import rushhour.rhproject.entities.Role;
import rushhour.rhproject.entities.User;
import rushhour.rhproject.modelviews.*;
import rushhour.rhproject.services.interfaces.ActivityService;
import rushhour.rhproject.services.interfaces.AppointmentService;
import rushhour.rhproject.services.interfaces.RoleService;
import rushhour.rhproject.services.interfaces.UserService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private ActivityService activityService;
    private AppointmentService appointmentService;
    private RoleService roleService;
    private UserService userService;

    @Autowired
    public AdminController(ActivityService activityService, AppointmentService appointmentService, RoleService roleService, UserService userService) {
        this.activityService = activityService;
        this.appointmentService = appointmentService;
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/admin-panel")
    public ModelAndView adminpage(){
        ModelAndView model = new ModelAndView("admin/adminpanel");
        /*ModelMapper mapper = new ModelMapper();
        PropertyMap<Activity, ActivityViewModel> activityMap = new PropertyMap<Activity, ActivityViewModel>() {
            @Override
            protected void configure() {
                map().se();
            }
        }

        ActivityViewModel activityViewModel = mapper.map(activityService.getAllActivities(), ActivityViewModel.class);
        AppointmentViewModel appointmentViewModel = mapper.map(appointmentService.getAllAppointments(), AppointmentViewModel.class);
        RoleViewModel roleViewModel = mapper.map(roleService.getAllRoles(), RoleViewModel.class);
        UserViewModel userViewModel = mapper.map(userService.getAllUsers(), UserViewModel.class);

        AllInfoDTO allInfo = new AllInfoDTO(activityViewModel,appointmentViewModel,roleViewModel,userViewModel);
        */
        model.addObject("Activities", activityService.getAllActivities());
        model.addObject("Appointments", appointmentService.getAllAppointments());
        model.addObject("Users", userService.getAllUsers());
        model.addObject("Roles", roleService.getAllRoles());

        return model;
    }
}
