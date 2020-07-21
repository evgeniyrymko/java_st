package by.resliv.task.cityguide.mapper;

import by.resliv.task.cityguide.dto.CityDto;
import by.resliv.task.cityguide.model.City;
import by.resliv.task.cityguide.model.CityDescription;
import by.resliv.task.cityguide.repository.CityDescriptionRepository;
import by.resliv.task.cityguide.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    private CityRepository cityRepository;

    private CityDescriptionRepository cityDescriptionRepository;

    @Autowired
    public CityMapper(CityRepository cityRepository, CityDescriptionRepository cityDescriptionRepository) {
        this.cityRepository = cityRepository;
        this.cityDescriptionRepository = cityDescriptionRepository;
    }

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
        city.setName(cityDto.getName());
        city.setCityDescription(cityDescription);
        return city;
    }
}
