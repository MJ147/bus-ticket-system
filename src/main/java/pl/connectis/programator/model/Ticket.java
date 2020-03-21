package pl.connectis.programator.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(value = EnumType.STRING)
    private TicketType type;
    @Transient
    private BigDecimal price;
    @Enumerated(value = EnumType.STRING)
    private ValidUntil validUntilType;
    private LocalDateTime validUntil;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;
    @ManyToOne
    @JoinColumn(name = "route_id")
    @JsonBackReference
    private Route route;

    public Ticket() {
    }

    public Ticket(TicketType type, ValidUntil validUntil) {
        this.type = type;
        this.validUntilType = validUntil;
        this.validUntil = validUntil.getValidUntil();
    }

    public Ticket(TicketType type, ValidUntil validUntil, Route route, Client client) {
        this.type = type;
        this.price = route.getPrice().multiply(new BigDecimal(type.getDiscount()));
        this.validUntilType = validUntil;
        this.validUntil = validUntil.getValidUntil();
        this.route = route;
        this.client = client;
    }

    public void setRoute(Route route) {
        this.route = route;
        this.price = route.getPrice().multiply(new BigDecimal(type.getDiscount()));
    }

    public BigDecimal getTicketPrice(Route route) {
        return route.getPrice().multiply(new BigDecimal(type.getDiscount()));
    }

}
