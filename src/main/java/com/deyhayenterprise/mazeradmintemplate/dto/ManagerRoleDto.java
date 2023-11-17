package com.deyhayenterprise.mazeradmintemplate.dto;

import com.deyhayenterprise.mazeradmintemplate.enumeration.ManagerRoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerRoleDto {
    private UUID id;
    private ManagerRoleType roleType;
}
