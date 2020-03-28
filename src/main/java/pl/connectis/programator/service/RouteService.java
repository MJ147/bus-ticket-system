package pl.connectis.programator.service;

import org.springframework.stereotype.Service;
import pl.connectis.programator.model.Route;

import java.util.List;

@Service
public interface RouteService {

    Route save(Route route);

    List<Route> findAll();

    void delete(Route route);
}
