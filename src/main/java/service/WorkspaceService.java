package service;


import dto.WorkspaceCreateDTO;
import dto.WorkspaceDTO;
import dto.WorkspaceUpdateDto;
import entity.Workspace;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mapper.WorkspaceMapper;
import repository.WorkspaceRepository;
import validator.WorkspaceValidator;


import java.util.List;

@ApplicationScoped
public class WorkspaceService
        extends AbstractService<WorkspaceMapper, WorkspaceRepository, WorkspaceValidator>
        implements service.CrudService<WorkspaceDTO, WorkspaceCreateDTO, WorkspaceUpdateDto, String> {

    @Inject
    public WorkspaceService(WorkspaceMapper mapper,WorkspaceRepository repository, WorkspaceValidator validator) {
        super(mapper, repository, validator);
    }

    @Override
    public void create(WorkspaceCreateDTO dto) {
        Workspace warehouse = mapper.fromDto(dto);
        repository.save(warehouse);
    }

    @Override
    public  WorkspaceDTO update(WorkspaceUpdateDto dto, String id) {
        Workspace warehouse = validator.existsAndGet(id);
        mapper.fromDto(dto, warehouse);
        Workspace save = repository.save(warehouse);
        return mapper.toDto(save);
    }

    @Override
    public WorkspaceDTO get(String id) {
        return mapper.toDto(validator.existsAndGet(id));
    }

    @Override
    public List<WorkspaceDTO> getAll() {
        List<Workspace> warehouses = repository.findAll();
        return mapper.toDto(warehouses);
    }

    @Override
    public void delete(String id) {
        Workspace warehouse = validator.existsAndGet(id);
        repository.delete(warehouse);
    }


}
