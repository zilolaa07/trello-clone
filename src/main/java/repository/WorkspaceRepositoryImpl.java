package repository;

import entity.Workspace;
import jakarta.enterprise.context.ApplicationScoped;


import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class WorkspaceRepositoryImpl implements WorkspaceRepository {
    @Override
    public Optional<Workspace> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Workspace> findAll() {
        return List.of();
    }

    @Override
    public Workspace save(Workspace entity) {
        return null;
    }

    @Override
    public void delete(Workspace entity) {

    }
}
