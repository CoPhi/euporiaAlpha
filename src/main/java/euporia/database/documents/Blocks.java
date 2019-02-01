package euporia.database.documents;

import euporia.database.catalogues.CatalogueObject;

import javax.persistence.*;

@Entity(name = "Blocks")
public class Blocks {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "object_id", foreignKey = @ForeignKey(name = "BLOCK_OBJECT_FK"))
    private CatalogueObject object;

    // TODO define N
    @Column(length = 40)
    private String n;

    // TODO define an ENUM for type?
    @Column(length = 40)
    private String type;

    @org.hibernate.annotations.Type(type = "text")
    private String content;
}
