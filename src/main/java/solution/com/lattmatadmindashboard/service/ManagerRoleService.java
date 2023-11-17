package solution.com.lattmatadmindashboard.service;

import solution.com.lattmatadmindashboard.dto.ManagerRoleDto;
import solution.com.lattmatadmindashboard.enumeration.ManagerRoleType;

public interface ManagerRoleService {
    ManagerRoleDto getRoleByRoleType(ManagerRoleType managerRoleType);
}
