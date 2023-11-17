package solution.com.lattmatadmindashboard.service.impl;

import solution.com.lattmatadmindashboard.dto.ManagerDto;
import solution.com.lattmatadmindashboard.entity.Manager;
import solution.com.lattmatadmindashboard.repo.ManagerRepository;
import solution.com.lattmatadmindashboard.service.ManagerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ModelMapper modelMapper;
    private final ManagerRepository managerRepository;

    @Override
    public Optional<Manager> findUserByPhoneNumber(String phoneNumber) {
        return managerRepository.findManagerByPhoneNumber(phoneNumber);
    }

    @Override
    public Optional<Manager> findUserByUsername(String username) {
        return managerRepository.findManagerByUsername(username);
    }

    @Override
    public Optional<Manager> findUsersByLoginId(String userid) {
        return managerRepository.findManagerByLoginId(userid);
    }

    @Override
    public Optional<Manager> findUsersById(UUID id) {
        return managerRepository.findById(id);
    }

    @Override
    public ManagerDto saveUser(ManagerDto user) {
        Manager u = modelMapper.map(user, Manager.class);
        u = managerRepository.save(u);
        return modelMapper.map(u, ManagerDto.class);
    }
}
