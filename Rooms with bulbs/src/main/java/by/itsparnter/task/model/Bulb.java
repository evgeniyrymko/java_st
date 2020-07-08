package by.itsparnter.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Bulb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean isTurnedOn;

    @OneToOne(mappedBy = "bulb", cascade = CascadeType.ALL)
    @JsonIgnore
    private Room room;

    public Bulb() {
    }

    public Bulb(boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        isTurnedOn = turnedOn;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
