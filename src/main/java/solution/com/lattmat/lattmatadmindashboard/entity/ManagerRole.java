package solution.com.lattmat.lattmatadmindashboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import solution.com.lattmat.lattmatadmindashboard.enumeration.ManagerRoleType;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ManagerRole {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private ManagerRoleType roleType;

    @ManyToMany(mappedBy = "managerRoles")
    private Set<Manager> managerList;

    public ManagerRole(ManagerRoleType roleType){
        this.roleType = roleType;
    }
}
