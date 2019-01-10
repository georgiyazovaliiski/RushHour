package rushhour.rhproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rushhour.rhproject.entities.BaseEntity;

@Repository
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T,Integer> {

}
