package euporia.database.versioning;

import euporia.database.catalogues.CatalogueObject;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Registry")
public class Registry {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "catalogue_object_id", foreignKey = @ForeignKey(name = "REGISTRY_CATALOGUE_OBJECT_ID_FK"))
    private CatalogueObject object;

    @ManyToOne
    @JoinColumn(name = "status_id", foreignKey = @ForeignKey(name = "REGISTRY_STATUS_ID_FK"))
    private Status status;

    @ManyToOne
    @JoinColumn(name = "action_id", foreignKey = @ForeignKey(name = "REGISTRY_ACTION_ID_FK"))
    private Actions action;


    @ManyToOne
    @JoinColumn(name = "history_id", foreignKey = @ForeignKey(name = "REGISTRY_HISTORY_ID_FK"))
    private History history;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public Registry(){}

    public Registry(CatalogueObject object, Status status, Actions action, History history) {
        this.object = object;
        this.status = status;
        this.action = action;
        this.history = history;
        this.timestamp = new Date();
    }

    public Registry(CatalogueObject object, Status status, Actions action, History history, Date timestamp) {
        this.object = object;
        this.status = status;
        this.action = action;
        this.history = history;
        this.timestamp = timestamp;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public Actions getAction() {
        return action;
    }

    public void setAction(Actions action) {
        this.action = action;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
