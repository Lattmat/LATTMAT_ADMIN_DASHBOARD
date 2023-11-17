package solution.com.lattmatadmindashboard.repo;


import solution.com.lattmatadmindashboard.entity.ManagerRole;
import solution.com.lattmatadmindashboard.enumeration.ManagerRoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManagerRoleRepository extends JpaRepository<ManagerRole, UUID> {
    Optional<ManagerRole> findManagerRoleByRoleType(ManagerRoleType managerRoleType);
}
