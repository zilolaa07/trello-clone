package uz.pdp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class TaskDto {
    private Long id;
    private String name;
    private LocalDate deadline;
    private String description;
    private String workspaceId;
    private Integer sortOrder;
}
