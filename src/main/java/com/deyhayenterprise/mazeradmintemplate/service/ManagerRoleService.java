package com.deyhayenterprise.mazeradmintemplate.service;

import com.deyhayenterprise.mazeradmintemplate.dto.ManagerRoleDto;
import com.deyhayenterprise.mazeradmintemplate.enumeration.ManagerRoleType;

public interface ManagerRoleService {
    ManagerRoleDto getRoleByRoleType(ManagerRoleType managerRoleType);
}
