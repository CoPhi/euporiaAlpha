package euporia.database.documents;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Containers")
public class Containers {

    @Id
    @GeneratedValue
    private long id;

    // TODO division

    private int position;

    public Containers(){}

    public Containers(int position) {
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
