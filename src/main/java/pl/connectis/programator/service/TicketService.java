package pl.connectis.programator.service;

import org.springframework.stereotype.Service;
import pl.connectis.programator.model.Ticket;

import java.util.List;

@Service
public interface TicketService {

    Ticket save(Ticket ticket);

    List<Ticket> findAll();

    void delete(Ticket ticket);
}
