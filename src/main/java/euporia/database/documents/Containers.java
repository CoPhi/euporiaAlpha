package euporia.database.documents;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Containers")
public class Containers {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "divison_id", foreignKey = @ForeignKey(name = "CONTAINERS_DIVISION_ID_FK"))
    private Divisions division;

    @Column(nullable = false)
    private int position;

    @ManyToMany
    private List<Blocks> blocks;

    public Containers(){}

    public Containers(Divisions division, int position, List<Blocks> blocks) {
        this.division = division;
        this.position = position;
        this.blocks = blocks;
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

    public Divisions getDivision() {
        return division;
    }

    public void setDivision(Divisions division) {
        this.division = division;
    }

    public List<Blocks> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Blocks> blocks) {
        this.blocks = blocks;
    }
}
