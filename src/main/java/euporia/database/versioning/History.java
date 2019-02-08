package euporia.database.versioning;

import javax.persistence.*;

@Entity(name = "History")
public class History {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "registry_id", foreignKey = @ForeignKey(name = "HISTORY_REGISTRY_ID_FK"))
    private Registry registry;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 60)
    private String type;

    @org.hibernate.annotations.Type(type = "text")
    private String content;

    public History(){}

    public History(Registry registry, String name, String type, String content) {
        this.registry = registry;
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

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
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
