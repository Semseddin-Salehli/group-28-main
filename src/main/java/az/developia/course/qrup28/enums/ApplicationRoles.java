package az.developia.course.qrup28.enums;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static az.developia.course.qrup28.enums.ApplicationPermission.*;

public enum ApplicationRoles {
    USER(Sets.newHashSet(READ)),
    ADMIN(Sets.newHashSet(READ, WRITE));

    private final Set<ApplicationPermission> permissions;

    ApplicationRoles(Set<ApplicationPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthority() {
        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = getPermissions().stream()
                .map(applicationPermission -> new SimpleGrantedAuthority(applicationPermission.getPermissionName()))
                .collect(Collectors.toSet());

        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return simpleGrantedAuthorities;
    }
}
