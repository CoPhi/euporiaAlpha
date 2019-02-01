package euporia.database.usermanagement;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Groups")
public class Groups {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 40, unique = true)
    private String name;

    @org.hibernate.annotations.Type(type = "text")
    private String info;

    @ManyToMany
    private List<User> users;

    @ManyToMany
    private List<Roles> roles;

    public Groups(){}

    public Groups(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
