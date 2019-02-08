package euporia.database.versioning;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Actions")
public class Actions {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String action;

    @org.hibernate.annotations.Type(type = "text")
    private String info;

    public Actions(){}

    public Actions(String action, String info) {
        this.action = action;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
