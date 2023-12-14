package solution.com.lattmat.lattmatadmindashboard.entity;

import jakarta.persistence.*;
import lombok.*;
import solution.com.lattmat.security.enumeration.LoginProvider;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String loginId;

    private String username;
    private String firstName;
    private String lastName;

    private String countryCode;

    @Column(unique = true)
    private String phoneNumber;

    private String password;
    private String mail;
    private String profileImage;
    private Date dob;
    private String gender;
    private boolean isActive;
    private boolean isLock;

    @Enumerated(EnumType.STRING)
    private LoginProvider provider;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    public void addRole(Role role) {
        if(roles.isEmpty()){
           roles = new HashSet<>();
        }

        roles.add(role);
    }
}
