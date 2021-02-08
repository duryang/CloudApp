package ps.exalt.training.gor.cloudapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ps.exalt.training.gor.cloudapp.models.Server;
import ps.exalt.training.gor.cloudapp.repositories.ServerRepository;
import ps.exalt.training.gor.cloudapp.services.ServerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @GetMapping
    public List<Server> getAll() {

        return serverService.getAllServers();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Server getById(@PathVariable int id) {
        return serverService.getServerById(id);
    }
}
