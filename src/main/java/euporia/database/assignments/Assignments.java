package euporia.database.assignments;

import euporia.database.catalogues.CatalogueObject;
import euporia.database.usermanagement.Groups;
import euporia.database.usermanagement.Roles;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Assignments")
public class Assignments {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "catalogue_object_id", foreignKey = @ForeignKey(name = "ASSIGNMENTS_OBJECT_ID_FK"))
    private CatalogueObject catalogueObject;


    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name = "ASSIGNMENTS_GROUPS_ID_FK"))
    private Groups group;

    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "ASSIGNMENTS_ROLES_ID_FK"))
    private Roles role;

    @ManyToMany
    private List<Permissions> permissions;

    public Assignments(){}

    public Assignments(CatalogueObject catalogueObject, Groups group, Roles role, List<Permissions> permissions) {
        this.catalogueObject = catalogueObject;
        this.group = group;
        this.role = role;
        this.permissions = permissions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CatalogueObject getCatalogueObject() {
        return catalogueObject;
    }

    public void setCatalogueObject(CatalogueObject catalogueObject) {
        this.catalogueObject = catalogueObject;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }
}
