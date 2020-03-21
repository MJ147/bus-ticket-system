package pl.connectis.programator.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String secondName;
    @OneToMany(mappedBy = "client", fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<Ticket> tickets = new ArrayList<>();

    public Client() {
    }

    public Client(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.tickets = new ArrayList<>();
    }

    public Client(String firstName, String secondName, Ticket ticket) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.tickets.add(ticket);
    }

    public Client(String firstName, String secondName, List<Ticket> tickets) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.tickets.addAll(tickets);
    }

}
