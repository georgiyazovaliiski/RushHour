package rushhour.rhproject.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rushhour.rhproject.entities.Appointment;
import rushhour.rhproject.repositories.AppointmentRepository;
import rushhour.rhproject.services.interfaces.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Iterable<Appointment> getAllByUserId(int Id) {
        return appointmentRepository.getAllAppointmentsById(Id);
    }

    @Override
    public Iterable<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
