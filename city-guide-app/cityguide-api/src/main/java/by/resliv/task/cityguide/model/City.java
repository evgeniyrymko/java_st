package by.resliv.task.cityguide.model;

import javax.persistence.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToOne
    @JoinColumn
    private CityDescription cityDescription;

    public City() {
    }

    public City(String name, CityDescription cityDescription) {
        this.name = name;
        this.cityDescription = cityDescription;
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

    public CityDescription getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(CityDescription cityDescription) {
        this.cityDescription = cityDescription;
    }
}
