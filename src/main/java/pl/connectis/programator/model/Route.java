package pl.connectis.programator.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price",
    columnDefinition = "NUMERIC")
    private BigDecimal price;
    private String start;
    private String destination;
    @Column(name = "trip_duration")
    private int tripDuration;
    @OneToMany(mappedBy = "route")
    @JsonManagedReference
    private List<Ticket> tickets = new ArrayList<>();

    public Route() {
    }

    public Route(BigDecimal price, String start, String destination, int tripDuration) {
        this.price = price;
        this.start = start;
        this.destination = destination;
        this.tripDuration = tripDuration;
    }

    public Route(BigDecimal price, String start, String destination, int tripDuration, Ticket ticket) {
        this.price = price;
        this.start = start;
        this.destination = destination;
        this.tripDuration = tripDuration;
        this.tickets.add(ticket);
    }

    public Route(BigDecimal price, String start, String destination, int tripDuration, List<Ticket> tickets) {
        this.price = price;
        this.start = start;
        this.destination = destination;
        this.tripDuration = tripDuration;
        this.tickets.addAll(tickets);
    }

}
