package by.itsparnter.task.dto;

public class RoomDto {

    private long id;
    private String name;
    private String countryName;
    private boolean isBulbTurnedOn;

    public RoomDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isBulbTurnedOn() {
        return isBulbTurnedOn;
    }

    public void setBulbTurnedOn(boolean bulbTurnedOn) {
        isBulbTurnedOn = bulbTurnedOn;
    }
}
