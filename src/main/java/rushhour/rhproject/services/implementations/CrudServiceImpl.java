package rushhour.rhproject.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rushhour.rhproject.entities.BaseEntity;
import rushhour.rhproject.repositories.BaseRepository;
import rushhour.rhproject.services.interfaces.CrudService;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public abstract class CrudServiceImpl<T extends BaseEntity> implements CrudService<T> {

    protected BaseRepository<T> baseRepository;

    @Autowired
    public CrudServiceImpl(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    abstract void preInsert(T entity);

    abstract void postInsert(T entity);

    /*@Override
    public Optional<T> getOne(Integer id) {
        return baseRepository.findById(id);
    }*/

    /*@Override
    public List<T> getAll() {
        return baseRepository.findAll();
    }*/

    /*@Override
    public Optional<T> insert(T entity) {
        preInsert(entity);

        T save = baseRepository.save(entity);

        postInsert(entity);

        return Optional.of(save);
    }*/
}