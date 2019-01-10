package rushhour.rhproject.services.interfaces;

import org.springframework.stereotype.Service;
import rushhour.rhproject.entities.Activity;

import java.util.Optional;

public interface ActivityService extends CrudService<Activity> {
    Iterable<Activity> getAllActivities();
    Optional<Activity> getById(int id);
}
