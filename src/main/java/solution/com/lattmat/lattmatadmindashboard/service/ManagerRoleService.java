package solution.com.lattmat.lattmatadmindashboard.service;

import solution.com.lattmat.lattmatadmindashboard.dto.ManagerRoleDto;
import solution.com.lattmat.lattmatadmindashboard.enumeration.ManagerRoleType;

public interface ManagerRoleService {
    ManagerRoleDto getRoleByRoleType(ManagerRoleType managerRoleType);
}
