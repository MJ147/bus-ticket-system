package pl.connectis.programator.service.impl;

import org.springframework.stereotype.Service;
import pl.connectis.programator.dao.ClientDAO;
import pl.connectis.programator.model.Client;
import pl.connectis.programator.service.ClientService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public Client save(Client client) {
        return clientDAO.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public void delete(Client client) {
        clientDAO.delete(client);
    }

    @Override
    public List<Client> findAllByTickets_ValidUntilAfter(LocalDateTime validUntil) {
        return clientDAO.findAllByTickets_ValidUntilAfter(validUntil);
    }

    @Override
    public List<Client> findDistinctByTickets_ValidUntilAfter(LocalDateTime validUntil) {
        return clientDAO.findDistinctByTickets_ValidUntilAfter(validUntil);
    }


}
