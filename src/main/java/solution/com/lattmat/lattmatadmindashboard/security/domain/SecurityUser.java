package solution.com.lattmat.lattmatadmindashboard.security.domain;

import solution.com.lattmat.lattmatadmindashboard.entity.Manager;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class SecurityUser implements UserDetails {

    private Manager user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getManagerRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleType().name()))
                .toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getPhoneNumber();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isLock();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isLock();
    }
}
