package pl.connectis.programator.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.connectis.programator.model.Ticket;

import java.util.List;

@Repository
public interface TicketDAO extends CrudRepository<Ticket, Long> {

    Ticket save(Ticket ticket);

    List<Ticket> findAll();

    void delete(Ticket ticket);
}
