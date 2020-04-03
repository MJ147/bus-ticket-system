package pl.connectis.programator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.connectis.programator.model.Client;
import pl.connectis.programator.service.ClientService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class ClientController {

    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }

    @DeleteMapping("/delete")
    public HttpStatus delete(@RequestBody Client client) {
        clientService.delete(client);
        return HttpStatus.OK;
    }

    @GetMapping("/ticket-after")
    public ResponseEntity<List<Client>> getAllByTicketsAfterValidUntilDate(@RequestParam String time) {
        return ResponseEntity.ok(clientService.findAllByTickets_ValidUntilAfter(LocalDateTime.parse(time))
                .stream()
                .distinct()
                .collect(Collectors.toList()));
    }

    @GetMapping("/distinct/ticket-after")
    public ResponseEntity<List<Client>> getAllDistinctByTicketsAfterValidUntilDate(@RequestParam String time) {
        return ResponseEntity.ok(clientService.findDistinctByTickets_ValidUntilAfter(LocalDateTime.parse(time)));
    }
}
