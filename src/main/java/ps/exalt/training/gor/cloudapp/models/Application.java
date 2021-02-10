package ps.exalt.training.gor.cloudapp.models;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.data.aerospike.annotation.*;
import org.springframework.data.annotation.Id;

import javax.annotation.Generated;

public class Application {

    @Id
    private Integer id;
    private String name;
    private Integer storage;
    private Integer serverId;
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

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }

    //endregion
}
