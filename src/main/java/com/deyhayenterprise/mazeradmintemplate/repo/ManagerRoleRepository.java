package com.deyhayenterprise.mazeradmintemplate.repo;


import com.deyhayenterprise.mazeradmintemplate.entity.ManagerRole;
import com.deyhayenterprise.mazeradmintemplate.enumeration.ManagerRoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManagerRoleRepository extends JpaRepository<ManagerRole, UUID> {
    Optional<ManagerRole> findManagerRoleByRoleType(ManagerRoleType managerRoleType);
}
