package euporia.database.usermanagement;

import javax.persistence.*;
import java.util.List;

@Entity(name = "roles")
public class Roles {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.ORDINAL)
    private GroupRoles roles;

    @ManyToMany(mappedBy = "roles")
    private List<Groups> groups;

    public Roles(){}

    public Roles(GroupRoles roles, List<Groups> groups) {
        this.roles = roles;
        this.groups = groups;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GroupRoles getRoles() {
        return roles;
    }

    public void setRoles(GroupRoles roles) {
        this.roles = roles;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}
