package rushhour.rhproject.services.interfaces;

import rushhour.rhproject.entities.Appointment;

public interface AppointmentService {
    Iterable<Appointment> getAllByUserId(int Id);

    Iterable<Appointment> getAllAppointments();
}
