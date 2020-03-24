package pl.connectis.programator.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.connectis.programator.model.Client;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClientDAO extends CrudRepository<Client, Long> {

    Client save(Client client);

    List<Client> findAll();

    void delete(Client client);

    List<Client> findAllByTickets_ValidUntilAfter(LocalDateTime validUntil);

    List<Client> findDistinctByTickets_ValidUntilAfter(LocalDateTime validUntil);
}
