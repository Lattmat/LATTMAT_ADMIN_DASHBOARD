package solution.com.lattmat.lattmatadmindashboard.repo;


import solution.com.lattmat.lattmatadmindashboard.entity.ManagerRole;
import solution.com.lattmat.lattmatadmindashboard.enumeration.ManagerRoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManagerRoleRepository extends JpaRepository<ManagerRole, UUID> {
    Optional<ManagerRole> findManagerRoleByRoleType(ManagerRoleType managerRoleType);
}
