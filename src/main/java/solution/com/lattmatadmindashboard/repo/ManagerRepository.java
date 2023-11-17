package solution.com.lattmatadmindashboard.repo;

import solution.com.lattmatadmindashboard.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {
    Optional<Manager> findManagerByPhoneNumber(String phoneNumber);
    Optional<Manager> findManagerByUsername(String username);
    Optional<Manager> findManagerByLoginId(String loginId);
}
