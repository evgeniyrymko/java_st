package by.itsparnter.task.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @NotNull
    private Country country;

    @OneToOne
    @NotNull
    private Bulb bulb;

    public Room(String name, Country country, Bulb bulb) {
        this.name = name;
        this.country = country;
        this.bulb = bulb;
    }
}
