package rushhour.rhproject.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rushhour.rhproject.entities.Activity;
import rushhour.rhproject.repositories.ActivityRepository;
import rushhour.rhproject.repositories.BaseRepository;
import rushhour.rhproject.services.interfaces.ActivityService;
import rushhour.rhproject.services.interfaces.CrudService;

import java.util.Optional;

@Service
public class ActivityServiceImpl extends CrudServiceImpl<Activity> implements ActivityService {
    private ActivityRepository activityRepository;

    @Autowired
    public ActivityServiceImpl(BaseRepository activityRepository) {
        super(activityRepository);
        this.activityRepository = (ActivityRepository) activityRepository;
    }


    @Override
    public Iterable<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Optional<Activity> getById(int id) {
        return activityRepository.findById((int) id);
    }

    @Override
    public void save(Activity entity) {
        activityRepository.save(entity);
    }

    @Override
    public Iterable<Activity> getAll() {
        return activityRepository.findAll();
    }

    @Override
    public void deleteAll() {
        activityRepository.deleteAll();
    }

    @Override
    public void deleteById(int Id) {
        activityRepository.deleteById(Id);
    }

    @Override
    public boolean ifExists(Activity Entity) {
        return activityRepository.existsById(Entity.getId());
    }

    @Override
    void preInsert(Activity entity) {

    }

    @Override
    void postInsert(Activity entity) {

    }
}
