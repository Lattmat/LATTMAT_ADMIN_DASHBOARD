package com.deyhayenterprise.mazeradmintemplate.security.service;

import com.deyhayenterprise.mazeradmintemplate.entity.Manager;
import com.deyhayenterprise.mazeradmintemplate.entity.ManagerRole;
import com.deyhayenterprise.mazeradmintemplate.security.domain.SecurityUser;
import com.deyhayenterprise.mazeradmintemplate.service.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final ManagerService managerService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final Manager manager = managerService.findUsersByLoginId(userName)
                .orElseThrow(() -> new UsernameNotFoundException("There is no user"));

        return new org.springframework.security.core.userdetails.User(manager.getMail(),
                manager.getPassword(),
                mapRolesToAuthorities(manager.getManagerRoles()));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection <ManagerRole> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleType().name()))
                .collect(Collectors.toList());
        return mapRoles;
    }

}