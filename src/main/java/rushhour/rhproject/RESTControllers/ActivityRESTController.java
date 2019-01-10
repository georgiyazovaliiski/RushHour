package rushhour.rhproject.RESTControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rushhour.rhproject.config.ConverterToList;
import rushhour.rhproject.entities.Activity;
import rushhour.rhproject.services.interfaces.ActivityService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activities")
public class ActivityRESTController {

    //public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    private ActivityService activityService; //Service which will do all data retrieval/manipulation work

    @Autowired
    public ActivityRESTController(ActivityService activityService) {
        this.activityService = activityService;
    }

// -------------------Retrieve All Users---------------------------------------------

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Activity>> listAllUsers() {
        List<Activity> activities = (List<Activity>) ConverterToList.getCollectionFromIteralbe(activityService.getAllActivities());
        if (activities.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }


    // -------------------Retrieve Single User------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") int id) {
        //logger.info("Fetching User with id {}", id);
        Optional<Activity> activity = activityService.getById(id);
        if (activity.isPresent() == false) {
            return new ResponseEntity(new Error("Activity with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Activity>(activity.get(), HttpStatus.OK);
    }

    // -------------------Create a User-------------------------------------------

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createActivity(@RequestBody Activity activity, UriComponentsBuilder ucBuilder) {
        //logger.info("Creating User : {}", user);

        if (activityService.ifExists(activity)) {
            //logger.error("Unable to create. A User with name {} already exist", user.getName());
            return new ResponseEntity(new Error("Unable to create. A User with name " +
                    activity.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        activityService.save(activity);     // MAP!!!

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/activities/{id}").buildAndExpand(activity.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a User ------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody Activity activity) {

        Optional<Activity> currentActivity = activityService.getById(id);

        if (currentActivity.isPresent() == false) {

            return new ResponseEntity(new Error("Unable to update. Activity with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentActivity.get().setName(activity.getName());
        currentActivity.get().setAppointments(activity.getAppointments());
        currentActivity.get().setDuration(activity.getDuration());
        currentActivity.get().setPrice(activity.getPrice());

        activityService.save(currentActivity.get());
        return new ResponseEntity<Activity>(currentActivity.get(), HttpStatus.OK);
    }

    // ------------------- Delete a User-----------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {


        Optional<Activity> activity = activityService.getById(id);
        if (activity.isPresent() == false) {

            return new ResponseEntity(new Error("Unable to deleteById. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        activityService.deleteById(id);
        return new ResponseEntity<Activity>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Users-----------------------------

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<Activity> deleteAllUsers() {
        activityService.deleteAll();
        return new ResponseEntity<Activity>(HttpStatus.NO_CONTENT);
    }
}
