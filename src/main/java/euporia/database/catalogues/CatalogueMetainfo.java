package euporia.database.catalogues;

import javax.persistence.*;

@Entity(name = "CatalogueMetainfo")
public class CatalogueMetainfo {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "catalogue_subject", foreignKey = @ForeignKey(name = "CATALOGUE_SUBJECT_FK"))
    private Catalogue catalogue;

    @Column(nullable = false)
    private String predicate, object;

    @org.hibernate.annotations.Type(type = "text")
    private String info;
}
