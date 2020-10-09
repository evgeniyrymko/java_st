package by.rymko.dto;

import javax.validation.constraints.NotBlank;

public class UserDto {

    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    public UserDto() {
    }

    public UserDto(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public UserDto(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
