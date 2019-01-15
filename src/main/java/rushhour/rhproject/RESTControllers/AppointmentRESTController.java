package rushhour.rhproject.RESTControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rushhour.rhproject.config.ConverterToList;
import rushhour.rhproject.entities.Activity;
import rushhour.rhproject.entities.Appointment;
import rushhour.rhproject.modelviews.CreateActivityModel;
import rushhour.rhproject.modelviews.CreateAppointmentModel;
import rushhour.rhproject.services.interfaces.AppointmentService;
import rushhour.rhproject.services.interfaces.UserService;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentRESTController {
    private AppointmentService appointmentService;
    private UserService userService;

    @Autowired
    public AppointmentRESTController(AppointmentService appointmentService, UserService userService) {
        this.appointmentService = appointmentService;
        this.userService = userService;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createAppointment(@RequestBody CreateAppointmentModel appointmentModel, UriComponentsBuilder ucBuilder) {
        Set<Activity> activities = new HashSet<>();

        for (CreateActivityModel a : appointmentModel.getActivities()) {
            Activity activity = new Activity(a.getName(),
                    ConverterToList.StringToDuration(a.getDuration()),
                    a.getPrice());

            activities.add(activity);
        }
        
        Appointment appointment = new Appointment(
                appointmentModel.getName(),
                ConverterToList.StringToInstant(appointmentModel.getStartDate()),
                ConverterToList.StringToInstant(appointmentModel.getEndDate()),
                userService.getById(1).get(),
                activities
        );
        

        appointmentService.save(appointment);


        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/appointments/{id}").buildAndExpand(appointment.getName()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> listAllAppointments() {
        List<Appointment> appointments = (List<Appointment>) ConverterToList.getCollectionFromIteralbe(appointmentService.getAllAppointments());
        if (appointments.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }


    // -------------------Retrieve Single Appointment------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAppointment(@PathVariable("id") int id) {
        //logger.info("Fetching User with id {}", id);
        Appointment appointment = appointmentService.getById(id);
        if (appointment != null) {
            return new ResponseEntity(new Error("Activity with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    // ------------------- Update an Appointment ------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAppointment(@PathVariable("id") int id, @RequestBody CreateAppointmentModel appointmentModel) {

        Appointment currentAppointment = appointmentService.getById(id);

        if (currentAppointment != null) {

            return new ResponseEntity(new Error("Unable to update. Activity with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentAppointment.setName(appointmentModel.getName());
        currentAppointment.setEndDate(ConverterToList.StringToInstant(appointmentModel.getEndDate()));
        currentAppointment.setStartDate(ConverterToList.StringToInstant(appointmentModel.getStartDate()));

        for (CreateActivityModel activity : appointmentModel.getActivities()) {
            //FIX APPOINTMENTS
        }

        appointmentService.save(currentAppointment);
        return new ResponseEntity<>(currentAppointment, HttpStatus.OK);
    }

    // ------------------- Delete an Appointment-----------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAppointment(@PathVariable("id") int id) {


        Appointment appointment = appointmentService.getById(id);
        if (appointment != null) {

            return new ResponseEntity(new Error("Unable to deleteById. Appointment with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        appointmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Appointments-----------------------------

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<Activity> deleteAllAppointments() {
        appointmentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
