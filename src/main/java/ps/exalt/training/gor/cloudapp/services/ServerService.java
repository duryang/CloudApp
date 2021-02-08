package ps.exalt.training.gor.cloudapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps.exalt.training.gor.cloudapp.models.Server;
import ps.exalt.training.gor.cloudapp.repositories.ServerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    public List<Server> getAllServers() {

        List<Server> servers = new ArrayList<>();
        serverRepository.findAll().forEach(servers::add);

        return servers;
    }

    public Server getServerById(int id) {
        return serverRepository.findById(id).get();
    }

    public void create(Server server) {
        serverRepository.save(server);
    }
}
