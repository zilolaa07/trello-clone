package uz.pdp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateDto {
    private String name;
    private String description;
    private Integer sortOrder;
    private String workspaceId;


}
