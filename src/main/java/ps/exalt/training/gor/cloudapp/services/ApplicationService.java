package ps.exalt.training.gor.cloudapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ps.exalt.training.gor.cloudapp.models.Application;
import ps.exalt.training.gor.cloudapp.models.Server;
import ps.exalt.training.gor.cloudapp.repositories.ApplicationRepository;
import ps.exalt.training.gor.cloudapp.repositories.ServerRepository;

import java.util.ArrayList;
import java.util.Comparator;
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
        apps.sort(Comparator.comparing(Application::getId));

        return apps;
    }

    public Application getApplicationById(int id) {
        return applicationRepository.findOne(id);
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
            serverToStore = new Server(app.getDbType());
            serverToStore.setId(allServers.size() + 1);
            serverService.create(serverToStore);
        }

        serverToStore.setFreeStorage(serverToStore.getFreeStorage() - app.getStorage());
        serverToStore.setUsedStorage(serverToStore.getUsedStorage() + app.getStorage());

        List<Application> allApplications = getAllApplications();
        app.setId(allApplications.size() + 1);
        app.setServerId(serverToStore.getId());
        serverToStore.getApplicationIds().add((long)app.getId());

        serverRepository.save(serverToStore);
        applicationRepository.save(app);
    }
}
