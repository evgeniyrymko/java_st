package by.rymko.task.libraryapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AuthorDto {

    private String id;

    @NotNull
    @Min(1)
    private String name;


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

}
