package euporia.database.documents;

import euporia.database.catalogues.CatalogueObject;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Blocks")
public class Blocks {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "object_id", foreignKey = @ForeignKey(name = "BLOCK_OBJECT_FK"))
    private CatalogueObject object;

    @ManyToMany
    private List<Containers> containers;

    @Column(nullable = false, length = 40)
    private String name;

    /**
     * Useful for frontend, every type needs to be
     * displayed differently.
     */
    // TODO define an ENUM for type?
    @Column(nullable = false, length = 40)
    private String type;

    @org.hibernate.annotations.Type(type = "text")
    private String content;

    public Blocks(){}

    public Blocks(long id, CatalogueObject object, List<Containers> containers, String name, String type, String content) {
        this.id = id;
        this.object = object;
        this.containers = containers;
        this.name = name;
        this.type = type;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CatalogueObject getObject() {
        return object;
    }

    public void setObject(CatalogueObject object) {
        this.object = object;
    }

    public List<Containers> getContainers() {
        return containers;
    }

    public void setContainers(List<Containers> containers) {
        this.containers = containers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
