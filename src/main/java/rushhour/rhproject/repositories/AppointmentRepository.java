package rushhour.rhproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rushhour.rhproject.entities.Activity;
import rushhour.rhproject.entities.Appointment;

@Repository
public interface AppointmentRepository extends BaseRepository<Appointment> {
    Iterable<Appointment> getAllAppointmentsById(int id);
}
