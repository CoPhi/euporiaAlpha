package euporia.database.usermanagement;

import javax.persistence.*;
import java.util.List;

@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 40, unique = true)
    private String user;

    @Column(nullable = false, length = 40, unique = true)
    private String email;

    @Column(nullable = false, length = 60, unique = true)
    private String password;

    // TODO enforce jwt token length
    @Column()
    private String jwtToken;

    @org.hibernate.annotations.Type(type = "text")
    private String info;

    @ManyToMany
    private List<Groups> groups;

    public User() {}

    public User(String user, String email, String password, String jwtToken, String info) {
        this.user = user;
        this.email = email;
        this.password = password;
        this.jwtToken = jwtToken;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}
