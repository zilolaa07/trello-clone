package entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.base.BaseEntity;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser extends BaseEntity {
    @Column(nullable = false)
    private String  username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    private Boolean superAdmin = Boolean.FALSE;

    private String phone;

    private String imageUrl;

    @ManyToMany(mappedBy = "members")
    private List<Workspace> workspace;

}
