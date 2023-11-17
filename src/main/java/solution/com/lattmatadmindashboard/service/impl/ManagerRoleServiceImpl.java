package solution.com.lattmatadmindashboard.service.impl;

import solution.com.lattmatadmindashboard.dto.ManagerRoleDto;
import solution.com.lattmatadmindashboard.entity.ManagerRole;
import solution.com.lattmatadmindashboard.enumeration.ManagerRoleType;
import solution.com.lattmatadmindashboard.repo.ManagerRoleRepository;
import solution.com.lattmatadmindashboard.service.ManagerRoleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ManagerRoleServiceImpl implements ManagerRoleService {

    private ModelMapper mapper;
    private ManagerRoleRepository managerRoleRepository;

    @Override
    public ManagerRoleDto getRoleByRoleType(ManagerRoleType managerRoleType) {
        ManagerRole managerRole = managerRoleRepository.findManagerRoleByRoleType(managerRoleType)
                .orElseGet(() -> managerRoleRepository.save(new ManagerRole(managerRoleType)));

        return mapper.map(managerRole, ManagerRoleDto.class);
    }

}
