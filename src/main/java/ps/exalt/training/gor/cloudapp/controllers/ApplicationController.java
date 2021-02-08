package ps.exalt.training.gor.cloudapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import ps.exalt.training.gor.cloudapp.models.Application;
import ps.exalt.training.gor.cloudapp.models.Server;
import ps.exalt.training.gor.cloudapp.services.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("/apps")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<Application> getAll() {
        return applicationService.getAllApplications();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Application getById(@PathVariable int id) {
        return applicationService.getApplicationById(id);
    }

    @PostMapping
    public Server create(@RequestBody final Application app) {
        applicationService.create(app);

        return app.getServer();
    }
}
