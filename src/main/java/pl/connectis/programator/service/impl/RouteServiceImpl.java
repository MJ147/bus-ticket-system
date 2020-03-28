package pl.connectis.programator.service.impl;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.stereotype.Service;
import pl.connectis.programator.dao.RouteDAO;
import pl.connectis.programator.model.Route;
import pl.connectis.programator.model.Ticket;
import pl.connectis.programator.service.RouteService;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    RouteDAO routeDAO;

    public RouteServiceImpl(RouteDAO routeDAO) {
        this.routeDAO = routeDAO;
    }

    @Override
    public Route save(Route route) {
        return routeDAO.save(route);
    }

    @Override
    public List<Route> findAll() {
        return routeDAO.findAll();
    }

    @Override
    public void delete(Route route) {
        routeDAO.delete(route);
    }

    public List<Route> getAllAvailableRoutes() {
        List<Route> availableRoutes = routeDAO.findAll();
        availableRoutes.stream().forEach(route -> route.setTickets(null));
        return availableRoutes;
    }

}
