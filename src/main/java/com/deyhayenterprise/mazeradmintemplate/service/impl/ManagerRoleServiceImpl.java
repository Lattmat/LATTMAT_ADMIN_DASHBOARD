package com.deyhayenterprise.mazeradmintemplate.service.impl;

import com.deyhayenterprise.mazeradmintemplate.dto.ManagerRoleDto;
import com.deyhayenterprise.mazeradmintemplate.entity.ManagerRole;
import com.deyhayenterprise.mazeradmintemplate.enumeration.ManagerRoleType;
import com.deyhayenterprise.mazeradmintemplate.repo.ManagerRoleRepository;
import com.deyhayenterprise.mazeradmintemplate.service.ManagerRoleService;
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
