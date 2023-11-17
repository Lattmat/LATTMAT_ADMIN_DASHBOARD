package solution.com.lattmat.lattmatadmindashboard.service;

import solution.com.lattmat.lattmatadmindashboard.dto.ManagerDto;
import solution.com.lattmat.lattmatadmindashboard.entity.Manager;

import java.util.Optional;
import java.util.UUID;

public interface ManagerService {
    Optional<Manager> findUserByPhoneNumber(String phoneNumber);
    Optional<Manager> findUserByUsername(String username);
    Optional<Manager> findUsersByLoginId(String userid);
    Optional<Manager> findUsersById(UUID id);
    ManagerDto saveUser(ManagerDto user);
}
