package euporia.database;

import javax.persistence.*;

@Entity(name = "Catalogue")
public class Catalogue {

    @Id
    @GeneratedValue()
    private Long id;

    @ManyToOne
    @JoinColumn(name = "object_id", foreignKey = @ForeignKey(name = "OBJECT_ID_FK"))
    private CatalogueObject object;

    private String type;

    private String name;

    public Catalogue(){}

    public Catalogue(CatalogueObject object, String type, String name) {
        this.object = object;
        this.type = type;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CatalogueObject getObject() {
        return object;
    }

    public void setObject(CatalogueObject object) {
        this.object = object;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
