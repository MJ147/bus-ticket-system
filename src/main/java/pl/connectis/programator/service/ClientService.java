package pl.connectis.programator.service;

import org.springframework.stereotype.Service;
import pl.connectis.programator.model.Client;
import pl.connectis.programator.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface ClientService {

    Client save(Client client);

    List<Client> findAll();

    void delete(Client client);

    List<Client> findAllByTickets_ValidUntilAfter(LocalDateTime validUntil);

    List<Client> findDistinctByTickets_ValidUntilAfter(LocalDateTime validUntil);

}
