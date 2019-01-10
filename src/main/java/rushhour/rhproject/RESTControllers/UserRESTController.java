package rushhour.rhproject.RESTControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rushhour.rhproject.config.ConverterToList;
import rushhour.rhproject.entities.User;
import rushhour.rhproject.services.interfaces.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserRESTController {

    //public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    private UserService userService; //Service which will do all data retrieval/manipulation work

    @Autowired
    public UserRESTController(UserService userService) {
        this.userService = userService;
    }

// -------------------Retrieve All Users---------------------------------------------

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> activities = (List<User>) ConverterToList.getCollectionFromIteralbe(userService.getAllUsers());
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
        Optional<User> user = userService.getById(id);
        if (user.isPresent() == false) {
            return new ResponseEntity(new Error("User with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    // -------------------Create a User-------------------------------------------

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        //logger.info("Creating User : {}", user);

        if (userService.ifExists(user)) {
            //logger.error("Unable to create. A User with name {} already exist", user.getName());
            return new ResponseEntity(new Error("Unable to create. A User with name " +
                    user.getFirstName() + " " + user.getLastName() + " already exist."),HttpStatus.CONFLICT);
        }
        userService.save(user);     // MAP!!!

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/activities/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a User ------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody User user) {

        Optional<User> currentUser = userService.getById(id);

        if (currentUser.isPresent() == false) {

            return new ResponseEntity(new Error("Unable to update. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentUser.get().setAppointments(user.getAppointments());

        userService.save(currentUser.get());
        return new ResponseEntity<User>(currentUser.get(), HttpStatus.OK);
    }

    // ------------------- Delete a User-----------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {


        Optional<User> user = userService.getById(id);
        if (user.isPresent() == false) {

            return new ResponseEntity(new Error("Unable to deleteById. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        userService.deleteById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Users-----------------------------

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        userService.deleteAll();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
