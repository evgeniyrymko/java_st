package by.resliv.task.cityguide.mapper;

import by.resliv.task.cityguide.dto.CityDto;
import by.resliv.task.cityguide.model.City;
import by.resliv.task.cityguide.model.CityDescription;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public CityDto convertToCityDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId().toString());
        cityDto.setName(city.getName());
        cityDto.setCityDescription(city.getCityDescription().getDescription());
        return cityDto;
    }

    public City convertToCity(CityDto cityDto) {
        CityDescription cityDescription = new CityDescription(cityDto.getCityDescription());
        City city = new City();
        if (cityDto.getId() != null && !cityDto.getId().isEmpty()) {
            city.setId(Long.parseLong(cityDto.getId()));
        }
        city.setName(cityDto.getName());
        city.setCityDescription(cityDescription);
        return city;
    }
}
