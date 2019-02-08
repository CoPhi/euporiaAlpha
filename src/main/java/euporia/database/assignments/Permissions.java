package euporia.database.assignments;

import javax.persistence.*;

@Entity(name = "Permissions")
public class Permissions {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PermissionEnum permission;

    private String description;

    public Permissions(){}

    public Permissions(PermissionEnum permission, String description) {
        this.permission = permission;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PermissionEnum getPermission() {
        return permission;
    }

    public void setPermission(PermissionEnum permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
