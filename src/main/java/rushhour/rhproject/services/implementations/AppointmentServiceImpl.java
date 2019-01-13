package rushhour.rhproject.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rushhour.rhproject.entities.Appointment;
import rushhour.rhproject.repositories.AppointmentRepository;
import rushhour.rhproject.repositories.BaseRepository;
import rushhour.rhproject.services.interfaces.AppointmentService;

@Service
public class AppointmentServiceImpl extends CrudServiceImpl<Appointment> implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(BaseRepository<Appointment> appointmentRepository) {
        super(appointmentRepository);
        this.appointmentRepository = (AppointmentRepository) appointmentRepository;
    }

    @Override
    void preInsert(Appointment entity) {

    }

    @Override
    void postInsert(Appointment entity) {

    }

    @Override
    public Iterable<Appointment> getAllByUserId(int Id) {
        return appointmentRepository.getAllAppointmentsById(Id);
    }

    @Override
    public Iterable<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getById(int Id) {
        return appointmentRepository.getOne(Id);
    }

    @Override
    public void save(Appointment entity) {
        appointmentRepository.save(entity);
    }

    @Override
    public Iterable<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public void deleteAll() {
        appointmentRepository.deleteAll();
    }

    @Override
    public void deleteById(int Id) {
        appointmentRepository.deleteById(Id);
    }

    @Override
    public boolean ifExists(Appointment Entity) {
        return false;
    }
}
