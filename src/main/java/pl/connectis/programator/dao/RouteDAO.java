package pl.connectis.programator.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.connectis.programator.model.Route;

import java.util.List;

@Repository
public interface RouteDAO extends CrudRepository<Route, Long> {

    Route save(Route route);

    List<Route> findAll();

    void delete(Route route);
}
