package az.developia.course.qrup28.enums;


public enum ApplicationRoles {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String permissions;

    ApplicationRoles(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }

}
