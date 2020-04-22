package pl.connectis.programator.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.connectis.programator.dao.ClientDAO;
import pl.connectis.programator.dao.RouteDAO;
import pl.connectis.programator.dao.TicketDAO;
import pl.connectis.programator.dao.WorkerDAO;
import pl.connectis.programator.model.*;

import java.math.BigDecimal;
import java.util.Arrays;

@Data
@Component
public class DataGenerator {

    ClientDAO clientDAO;
    RouteDAO routeDAO;
    TicketDAO ticketDAO;
    WorkerDAO workerDAO;

    public DataGenerator(ClientDAO clientDAO, RouteDAO routeDAO, TicketDAO ticketDAO, WorkerDAO workerDAO) {
        this.clientDAO = clientDAO;
        this.routeDAO = routeDAO;
        this.ticketDAO = ticketDAO;
        this.workerDAO = workerDAO;
    }

    public void createData() {
        Ticket ticket1 = new Ticket(TicketType.STUDENT, ValidUntil._24H);
        Ticket ticket2 = new Ticket(TicketType.NORMAL, ValidUntil._20M);
        Ticket ticket3 = new Ticket(TicketType.NORMAL, ValidUntil._24H);
        Ticket ticket4 = new Ticket(TicketType.PUPIL, ValidUntil._30D);
        Ticket ticket5 = new Ticket(TicketType.PUPIL, ValidUntil._30D);
        Ticket ticket6 = new Ticket(TicketType.SENIOR, ValidUntil._24H);
        Ticket ticket7 = new Ticket(TicketType.SENIOR, ValidUntil._20M);
        Ticket ticket8 = new Ticket(TicketType.STUDENT, ValidUntil._24H);

        Client client1 = new Client("Robin", "Jackman", Arrays.asList(ticket1, ticket8));
        Client client2 = new Client("Taylor", "Edward", ticket2);
        Client client3 = new Client("Vivian", "Dickens", ticket3);
        Client client4 = new Client("Harry", "Clifford", ticket4);
        Client client5 = new Client("Eliza", "Clifford", ticket5);
        Client client6 = new Client("Nancy", "Newman", ticket6);
        Client client7 = new Client("Melinda", "Clifford", ticket7);
        Client client8 = new Client("Harley", "Gilbert");

        clientDAO.save(client1);
        clientDAO.save(client2);
        clientDAO.save(client3);
        clientDAO.save(client4);
        clientDAO.save(client5);
        clientDAO.save(client6);
        clientDAO.save(client7);
        clientDAO.save(client8);

        Route route1 = new Route(new BigDecimal(189), "Gdańsk", "Warszawa", 180, Arrays.asList(ticket1, ticket2));
        Route route2 = new Route(new BigDecimal(68), "Kraków", "Częstochowa", 60, Arrays.asList(ticket3, ticket4));
        Route route3 = new Route(new BigDecimal(125), "Kraków", "Warszawa", 180, Arrays.asList(ticket5, ticket6));
        Route route4 = new Route(new BigDecimal(25), "Warszawa", "Radom", 180, Arrays.asList(ticket7, ticket8));
        routeDAO.save(route1);
        routeDAO.save(route2);
        routeDAO.save(route3);
        routeDAO.save(route4);

        ticket1.setClient(client1);
        ticket2.setClient(client2);
        ticket3.setClient(client3);
        ticket4.setClient(client4);
        ticket5.setClient(client5);
        ticket6.setClient(client6);
        ticket7.setClient(client7);
        ticket8.setClient(client1);
        ticket1.setRoute(route1);
        ticket2.setRoute(route1);
        ticket3.setRoute(route2);
        ticket4.setRoute(route2);
        ticket5.setRoute(route3);
        ticket6.setRoute(route3);
        ticket7.setRoute(route4);
        ticket8.setRoute(route4);
        ticketDAO.save(ticket1);
        ticketDAO.save(ticket2);
        ticketDAO.save(ticket3);
        ticketDAO.save(ticket4);
        ticketDAO.save(ticket5);
        ticketDAO.save(ticket6);
        ticketDAO.save(ticket7);
        ticketDAO.save(ticket8);

        Worker worker1 = new Worker("Andrzej", "Malinowski");
        Worker worker2 = new Worker("Marek", "Zygmuntowicz");
        Worker worker3 = new Worker("Jan", "Kowalski");
        Worker worker4 = new Worker("Janusz", "Nowak");

        workerDAO.save(worker1);
        workerDAO.save(worker2);
        workerDAO.save(worker3);
        workerDAO.save(worker4);
    }

    public void printAllData() {
        workerDAO.findAll().forEach(System.out::println);
        clientDAO.findAll().forEach(System.out::println);
        ticketDAO.findAll().forEach(System.out::println);
        routeDAO.findAll().forEach(System.out::println);
    }
}
