package mapper;

import jakarta.enterprise.context.ApplicationScoped;
import dto. WorkspaceCreateDTO;
import dto. WorkspaceDTO;
import dto. WorkspaceUpdateDto;
import entity.Workspace;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class WorkspaceMapper {

    // List<Entity> -> List<DTO>
    public List<WorkspaceDTO> toDto(List<Workspace> workspaces) {
        return workspaces.stream().map(this::toDto).collect(Collectors.toList());
    }

    // Entity -> DTO (Response)
    public WorkspaceDTO toDto(Workspace workspace) {
        WorkspaceDTO dto = new WorkspaceDTO();
        dto.setId(Long.valueOf(workspace.getId()));
        dto.setName(workspace.getName());
        return dto;
    }

    // Update DTO -> mavjud Entity yangilash
    public void fromDto(WorkspaceUpdateDto dto, Workspace workspace) {
        workspace.setName(dto.getName());
    }

    // Create DTO -> yangi Entity
    public Workspace fromDto(WorkspaceCreateDTO dto) {
        Workspace workspace = new Workspace();
        workspace.setName(dto.getName());
        return workspace;
    }
}
