package ps.exalt.training.gor.cloudapp.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Server {

    public Server(DbType dbType) {
        this.dbType = dbType;
        this.applications = new ArrayList<Application>();
    }

    @Id
    private Integer id;
    private DbType dbType;
    private final Integer maxStorage = 100;
    private Integer usedStorage;
    private Integer freeStorage;
    private List<Application> applications;

    // region Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }

    public Integer getMaxStorage() {
        return maxStorage;
    }

    public Integer getUsedStorage() {
        return usedStorage;
    }

    public void setUsedStorage(Integer usedStorage) {
        this.usedStorage = usedStorage;
    }

    public Integer getFreeStorage() {
        return freeStorage;
    }

    public void setFreeStorage(Integer freeStorage) {
        this.freeStorage = freeStorage;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    // endregion
}
