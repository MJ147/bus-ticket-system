package pl.connectis.programator.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String secondName;

    public Worker() {
    }

    public Worker(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
