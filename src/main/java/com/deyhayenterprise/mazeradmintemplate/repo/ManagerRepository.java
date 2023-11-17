package com.deyhayenterprise.mazeradmintemplate.repo;

import com.deyhayenterprise.mazeradmintemplate.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {
    Optional<Manager> findManagerByPhoneNumber(String phoneNumber);
    Optional<Manager> findManagerByUsername(String username);
    Optional<Manager> findManagerByLoginId(String loginId);
}
