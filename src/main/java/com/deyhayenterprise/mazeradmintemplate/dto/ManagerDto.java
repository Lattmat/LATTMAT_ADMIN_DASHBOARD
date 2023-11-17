package com.deyhayenterprise.mazeradmintemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerDto {

    private UUID id;
    private String loginId;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String mail;
    private String profileImage;
    private boolean isFirstTimeLogin;
    private boolean isActive;
    private boolean isLock;

    private Set<ManagerRoleDto> roles;

}
