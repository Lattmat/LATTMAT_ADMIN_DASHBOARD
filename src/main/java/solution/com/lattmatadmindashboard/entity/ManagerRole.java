package solution.com.lattmatadmindashboard.entity;

import solution.com.lattmatadmindashboard.enumeration.ManagerRoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
