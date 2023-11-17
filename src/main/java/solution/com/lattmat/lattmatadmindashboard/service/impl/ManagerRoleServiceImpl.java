package solution.com.lattmat.lattmatadmindashboard.service.impl;

import solution.com.lattmat.lattmatadmindashboard.dto.ManagerRoleDto;
import solution.com.lattmat.lattmatadmindashboard.entity.ManagerRole;
import solution.com.lattmat.lattmatadmindashboard.enumeration.ManagerRoleType;
import solution.com.lattmat.lattmatadmindashboard.repo.ManagerRoleRepository;
import solution.com.lattmat.lattmatadmindashboard.service.ManagerRoleService;
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
