package ps.exalt.training.gor.cloudapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ps.exalt.training.gor.cloudapp.models.Application;
import ps.exalt.training.gor.cloudapp.models.Server;
import ps.exalt.training.gor.cloudapp.repositories.ApplicationRepository;
import ps.exalt.training.gor.cloudapp.repositories.ServerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private ServerService serverService;

    public List<Application> getAllApplications() {

        List<Application> apps = new ArrayList<>();
        applicationRepository.findAll().forEach(apps::add);

        return apps;
    }

    public Application getApplicationById(int id) {
        return applicationRepository.findById(id).get();
    }

    public synchronized void create(Application app) {

        if (app.getStorage() > 100 && app.getStorage() < 0)
            return;

        List<Server> allServers = serverService.getAllServers();

        int minAvailable = 101;
        Server serverToStore = null;

        for (Server server : allServers) {
            if (server.getFreeStorage() >= app.getStorage() &&
                    server.getDbType() == app.getDbType() &&
                    server.getFreeStorage() < minAvailable) {
                minAvailable = server.getFreeStorage();
                serverToStore = server;
            }
        }

        // Not enough space in any of the existing servers.
        if (serverToStore == null) {
            Server newServer = new Server(app.getDbType());
            newServer.setId(allServers.get(allServers.size() - 1).getId() + 1);
            serverService.create(newServer);
            serverToStore = newServer;
        }

        serverToStore.getApplications().add(app);
        serverToStore.setFreeStorage(serverToStore.getFreeStorage() - app.getStorage());
        serverToStore.setUsedStorage(serverToStore.getUsedStorage() + app.getStorage());
        serverRepository.save(serverToStore);

        app.setServer(serverToStore);
        List<Application> allApplications = getAllApplications();
        app.setId(allApplications.get(allApplications.size() - 1).getId() + 1);
        applicationRepository.save(app);
    }
}
