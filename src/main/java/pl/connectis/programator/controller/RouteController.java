package pl.connectis.programator.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.connectis.programator.model.Route;
import pl.connectis.programator.service.impl.RouteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    RouteServiceImpl routeService;

    public RouteController(RouteServiceImpl routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Route>> findAll() {
        return ResponseEntity.ok(routeService.findAll());
    }

    @GetMapping("/available")
    public ResponseEntity<List<Route>> getAllAvailableRoutes() {
        return ResponseEntity.ok(routeService.getAllAvailableRoutes());
    }
}
