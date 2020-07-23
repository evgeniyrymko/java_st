package by.resliv.task.cityguide.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CityDto {

    private String id;

    @NotNull
    private String name;

    @NotNull
    @Min(10)
    private String cityDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }
}
