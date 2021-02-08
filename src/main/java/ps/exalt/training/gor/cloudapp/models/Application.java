package ps.exalt.training.gor.cloudapp.models;

import org.springframework.data.annotation.Id;

public class Application {

    @Id
    private Integer id;
    private String name;
    private Integer storage;
    private Server server;
    private DbType dbType;

    // region Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }

    //endregion
}
