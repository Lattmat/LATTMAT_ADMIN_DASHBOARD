package com.deyhayenterprise.mazeradmintemplate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String loginId;

    private String username;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String phoneNumber;

    private String password;

    @Column(unique = true)
    private String mail;

    private String profileImage;
    private boolean isFirstTimeLogin;
    private boolean isActive;
    private boolean isLock;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "manager_roles",
            joinColumns = @JoinColumn(
                    name = "manager_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<ManagerRole> managerRoles;

    public void addRole(ManagerRole managerRole) {
        if(managerRoles.isEmpty()){
           managerRoles = new HashSet<>();
        }

        managerRoles.add(managerRole);
    }
}
