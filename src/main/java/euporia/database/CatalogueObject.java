package euporia.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "CatalogueObject")
public class CatalogueObject {
    @Id
    @GeneratedValue
    private long id;

    private String type;

    public CatalogueObject(){}

    public CatalogueObject(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
