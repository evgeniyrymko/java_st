package by.itsparnter.task.model;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    private Country country;
    @OneToOne
    private Bulb bulb;

    public Room() {
    }

    public Room(String name, Country country, Bulb bulb) {
        this.name = name;
        this.country = country;
        this.bulb = bulb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Bulb getBulb() {
        return bulb;
    }

    public void setBulb(Bulb bulb) {
        this.bulb = bulb;
    }
}
