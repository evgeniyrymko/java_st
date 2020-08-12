package by.itsparnter.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Bulb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean isTurnedOn;

    @OneToOne(mappedBy = "bulb", cascade = CascadeType.ALL)
    @JsonIgnore
    private Room room;

    public Bulb(boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
    }
}
