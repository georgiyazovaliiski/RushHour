package rushhour.rhproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import rushhour.rhproject.entities.User;
import rushhour.rhproject.services.interfaces.AppointmentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
public class AppointmentController {
    private AppointmentService appointmentService;

    public AppointmentController() { }

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "/appointments")
    public ModelAndView allAppointments(){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = user.getId();

        ModelAndView model = new ModelAndView("/");
        model.addObject("appointments",appointmentService.getAllByUserId(userId));
        return new ModelAndView("/user/appointments");
    }



    private static <T> List<T> returnListFromIterable(Iterable<T> itr)
    {
        List<T> cltn = new ArrayList<T>();
        itr.forEach(cltn::add);

        // Return the converted collection
        return cltn;
    }
}
