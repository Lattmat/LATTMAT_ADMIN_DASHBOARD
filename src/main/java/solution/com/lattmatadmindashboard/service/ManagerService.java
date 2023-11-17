package solution.com.lattmatadmindashboard.service;

import solution.com.lattmatadmindashboard.dto.ManagerDto;
import solution.com.lattmatadmindashboard.entity.Manager;

import java.util.Optional;
import java.util.UUID;

public interface ManagerService {
    Optional<Manager> findUserByPhoneNumber(String phoneNumber);
    Optional<Manager> findUserByUsername(String username);
    Optional<Manager> findUsersByLoginId(String userid);
    Optional<Manager> findUsersById(UUID id);
    ManagerDto saveUser(ManagerDto user);
}
