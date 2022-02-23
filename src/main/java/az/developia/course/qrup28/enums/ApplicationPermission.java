package az.developia.course.qrup28.enums;

public enum ApplicationPermission {
    READ("read"),
    WRITE("write");

    private final String permissionName;

    ApplicationPermission(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionName() {
        return permissionName;
    }
}
