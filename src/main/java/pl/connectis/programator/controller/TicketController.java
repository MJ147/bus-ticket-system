package pl.connectis.programator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.connectis.programator.dao.TicketDAO;
import pl.connectis.programator.model.Route;
import pl.connectis.programator.model.Ticket;
import pl.connectis.programator.service.impl.TicketServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    TicketServiceImpl ticketService;

    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Ticket>> findAll() {
        ticketService.findAll().forEach(System.out::println);
        return ResponseEntity.ok(ticketService.findAll());
    }

    @GetMapping("/available")
    public ResponseEntity getAllAvailableTickets(@RequestParam(required = false) String format) {
        if ("text".equals(format)) {
            return ResponseEntity.ok(ticketService.getAllAvailableTicketsFormatText());
        }
        return ResponseEntity.ok(ticketService.getAllAvailableTickets());
    }

}
