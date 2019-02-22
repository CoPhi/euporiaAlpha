package euporia.database.documents;

import euporia.database.catalogues.Catalogue;
import euporia.database.catalogues.CatalogueObject;

import javax.persistence.*;

@Entity(name = "Divisions")
public class Divisions {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "catalogue_object_id", foreignKey = @ForeignKey(name = "DIVISIONS_OBJECT_ID_FK"))
    private CatalogueObject object;

    @ManyToOne
    @JoinColumn(name = "catalogue_id", foreignKey = @ForeignKey(name = "DIVISIONS_OBJECT_ID_FK"))
    private Catalogue catalogue;

    @Column(nullable = false)
    private int blockStart, blockEnd;

    @Column(nullable = false)
    private int level, division, position;

    @Column(nullable = false)
    private String name;

    public Divisions(){}

    public Divisions(CatalogueObject object, Catalogue catalogue, int blockStart, int blockEnd, int level, int division, int position, String name) {
        this.object = object;
        this.catalogue = catalogue;
        this.blockStart = blockStart;
        this.blockEnd = blockEnd;
        this.level = level;
        this.division = division;
        this.position = position;
        this.name = name;
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

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public int getBlockStart() {
        return blockStart;
    }

    public void setBlockStart(int blockStart) {
        this.blockStart = blockStart;
    }

    public int getBlockEnd() {
        return blockEnd;
    }

    public void setBlockEnd(int blockEnd) {
        this.blockEnd = blockEnd;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
