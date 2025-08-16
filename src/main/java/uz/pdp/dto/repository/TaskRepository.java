package uz.pdp.dto.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import uz.pdp.dto.model.entity.Task;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TaskRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Task task) {
        entityManager.persist(task);
    }

    public List<Task> findAll() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class)
                .getResultList();
    }

    public Optional<Task> findById(Long id) {
        Task task = entityManager.find(Task.class, id);
        return Optional.ofNullable(task);
    }

    public void update(Task task) {
        entityManager.merge(task);
    }

    public void delete(Long id) {
        Task task = entityManager.find(Task.class, id);
        if (task != null) {
            entityManager.remove(task);
        }
    }
}
