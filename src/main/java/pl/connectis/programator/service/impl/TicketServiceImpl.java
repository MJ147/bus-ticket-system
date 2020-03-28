package pl.connectis.programator.service.impl;

import org.springframework.stereotype.Service;
import pl.connectis.programator.dao.TicketDAO;
import pl.connectis.programator.model.Route;
import pl.connectis.programator.model.Ticket;
import pl.connectis.programator.model.TicketType;
import pl.connectis.programator.model.ValidUntil;
import pl.connectis.programator.service.RouteService;
import pl.connectis.programator.service.TicketService;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    TicketDAO ticketDAO;
    RouteService routeService;

    public TicketServiceImpl(TicketDAO ticketDAO, RouteService routeService) {
        this.ticketDAO = ticketDAO;
        this.routeService = routeService;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketDAO.save(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketDAO.findAll();
    }

    @Override
    public void delete(Ticket ticket) {
        ticketDAO.delete(ticket);
    }

    public List<Route> getAllAvailableTickets() {
        List<Route> routes = routeService.findAll();
        routes.forEach(route -> route.setTickets(availableCombinations()));
        return routes;
    }

    public List<String> getAllAvailableTicketsFormatText() {
        List<Ticket> tickets = availableCombinations();
        List<String> routesTextFormat = new ArrayList<>();
        for (Route route : routeService.findAll()) {
            for (int i = 0; i < tickets.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("Bilet " + tickets.get(i).getType().getType());
                sb.append(", " + tickets.get(i).getValidUntilType().toStringFormatted());
                sb.append(", cena: " + NumberFormat.getCurrencyInstance().format(tickets.get(i).getTicketPrice(route)));
                sb.append(", trasa przejazdu: " + route.getStart() + " - " + route.getDestination());
                routesTextFormat.add(sb.toString());
            }
        }
        return routesTextFormat;
    }

    private List<Ticket> availableCombinations() {
        Ticket student20M = new Ticket(TicketType.STUDENT, ValidUntil._20M);
        Ticket student24H = new Ticket(TicketType.STUDENT, ValidUntil._24H);
        Ticket student30D = new Ticket(TicketType.STUDENT, ValidUntil._30D);

        Ticket normal20M = new Ticket(TicketType.NORMAL, ValidUntil._20M);
        Ticket normal24H = new Ticket(TicketType.NORMAL, ValidUntil._24H);
        Ticket normal30D = new Ticket(TicketType.NORMAL, ValidUntil._30D);

        Ticket pupil20M = new Ticket(TicketType.PUPIL, ValidUntil._20M);
        Ticket pupil24H = new Ticket(TicketType.PUPIL, ValidUntil._24H);
        Ticket pupil30D = new Ticket(TicketType.PUPIL, ValidUntil._30D);

        Ticket senior20M = new Ticket(TicketType.SENIOR, ValidUntil._20M);
        Ticket senior24H = new Ticket(TicketType.SENIOR, ValidUntil._24H);
        Ticket senior30D = new Ticket(TicketType.SENIOR, ValidUntil._30D);

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(student20M);
        tickets.add(student24H);
        tickets.add(student30D);
        tickets.add(normal20M);
        tickets.add(normal24H);
        tickets.add(normal30D);
        tickets.add(pupil20M);
        tickets.add(pupil24H);
        tickets.add(pupil30D);
        tickets.add(senior20M);
        tickets.add(senior24H);
        tickets.add(senior30D);
        return tickets;
    }
}
