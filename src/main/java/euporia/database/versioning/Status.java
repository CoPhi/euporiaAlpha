package euporia.database.versioning;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Status")
public class Status {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String status;

    @org.hibernate.annotations.Type(type = "text")
    private String info;

    public Status(){}

    public Status(String status, String info) {
        this.status = status;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
