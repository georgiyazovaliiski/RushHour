package rushhour.rhproject.services.interfaces;

import rushhour.rhproject.entities.Appointment;

public interface AppointmentService extends CrudService<Appointment>{
    Iterable<Appointment> getAllByUserId(int Id);

    Iterable<Appointment> getAllAppointments();

    Appointment getById(int Id);
}
