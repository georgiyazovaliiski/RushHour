package rushhour.rhproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rushhour.rhproject.entities.Activity;

@Repository
public interface ActivityRepository extends BaseRepository<Activity> {
}
