package rushhour.rhproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import rushhour.rhproject.entities.Activity;
import rushhour.rhproject.services.interfaces.ActivityService;

import java.util.ArrayList;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
public class ActivityController {
    private ActivityService activityService;

    public ActivityController() { }
    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @RequestMapping(value = { "/activities" }, method = RequestMethod.GET)
    @GetMapping(value = "/activities")
    public ModelAndView allActivities(){
        ModelAndView model = new ModelAndView("/");
        model.addObject("activities",activityService.getAllActivities());
        return new ModelAndView("/");
    }



    private static <T> List<T> returnListFromIterable(Iterable<T> itr)
    {
        List<T> cltn = new ArrayList<T>();
        itr.forEach(cltn::add);

        // Return the converted collection
        return cltn;
    }
}
