package euporia.database.catalogues;

import javax.persistence.*;

@Entity(name = "CatalogueRelationships")
public class CatalogueRelationships {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "catalogue_ref", foreignKey = @ForeignKey(name = "CATALOGUE_REF_FK"))
    private Catalogue catalogue;

    @ManyToOne
    @Column(nullable = false)
    @JoinColumn(name = "catalogue_parent", foreignKey = @ForeignKey(name = "CATALOGUE_PARENT_FK"))
    private Catalogue parent;

    public CatalogueRelationships(){}

    public CatalogueRelationships(Catalogue catalogue, Catalogue parent) {
        this.catalogue = catalogue;
        this.parent = parent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Catalogue getParent() {
        return parent;
    }

    public void setParent(Catalogue parent) {
        this.parent = parent;
    }

}
