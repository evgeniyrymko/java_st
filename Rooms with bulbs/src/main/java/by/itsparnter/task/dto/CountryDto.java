package by.itsparnter.task.dto;

public class CountryDto implements Comparable<CountryDto> {

    private String name;

    public CountryDto() {
    }

    public CountryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(CountryDto o) {
        return name.compareTo(o.getName());
    }
}
