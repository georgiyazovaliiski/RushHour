package rushhour.rhproject.services.interfaces;

public interface CrudService<T> {
    void save(T entity);
    Iterable<T> getAll();
    void deleteAll();
    void deleteById(int Id);
    boolean ifExists(T Entity);
}
