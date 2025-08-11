package validator;

import entity.Workspace;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.WorkspaceRepository;

public class WorkspaceValidator {
    @ApplicationScoped
        @Inject
        private WorkspaceRepository repository;

        public Workspace existsAndGet(String id) {
            return repository.findById(id).orElseThrow(
                    () -> new RuntimeException("Workspace with id " + id + " not found")
            );
        }
    }

