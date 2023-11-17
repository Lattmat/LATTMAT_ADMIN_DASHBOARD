package com.deyhayenterprise.mazeradmintemplate.service;

import com.deyhayenterprise.mazeradmintemplate.dto.ManagerDto;
import com.deyhayenterprise.mazeradmintemplate.entity.Manager;

import java.util.Optional;
import java.util.UUID;

public interface ManagerService {
    Optional<Manager> findUserByPhoneNumber(String phoneNumber);
    Optional<Manager> findUserByUsername(String username);
    Optional<Manager> findUsersByLoginId(String userid);
    Optional<Manager> findUsersById(UUID id);
    ManagerDto saveUser(ManagerDto user);
}
