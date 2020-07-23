package by.resliv.task.cityguide.service;

import by.resliv.task.cityguide.dto.CityDto;
import by.resliv.task.cityguide.mapper.CityMapper;
import by.resliv.task.cityguide.model.City;
import by.resliv.task.cityguide.model.CityDescription;
import by.resliv.task.cityguide.repository.CityDescriptionRepository;
import by.resliv.task.cityguide.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CityService.class);

    private CityRepository cityRepository;

    private CityDescriptionRepository cityDescriptionRepository;

    private CityMapper cityMapper;

    @Autowired
    public CityService(CityRepository cityRepository, CityDescriptionRepository cityDescriptionRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityDescriptionRepository = cityDescriptionRepository;
        this.cityMapper = cityMapper;
    }

    public List<CityDto> getAllCities() {
        List<City> allCities = this.cityRepository.findAll();
        List<CityDto> allCitiesDto = allCities.stream()
                .map(city -> this.cityMapper.convertToCityDto(city))
                .collect(Collectors.toList());
        return allCitiesDto;
    }

    public CityDto getCityById(long id) {
        Optional<City> optionalCityRepositoryById = this.cityRepository.findById(id);
        if (!optionalCityRepositoryById.isPresent()) {
            throw new EntityNotFoundException();
        }
        CityDto cityDtoById = this.cityMapper.convertToCityDto(optionalCityRepositoryById.get());
        return cityDtoById;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public City addCity(CityDto cityDto) {
        City city = this.cityMapper.convertToCity(cityDto);
        cityDescriptionRepository.save(city.getCityDescription());
        cityRepository.save(city);
        return city;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public City updateCity(CityDto updatedCityDto) {
        City updatedCity = this.cityMapper.convertToCity(updatedCityDto);
        City cityById = cityRepository.findById(updatedCity.getId()).get();
        cityById.setName(updatedCity.getName());
        cityRepository.save(cityById);
        return cityById;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCity(long id) {
        City cityById = this.cityRepository.findById(id).get();
        CityDescription cityDescriptionById = cityById.getCityDescription();
        cityDescriptionRepository.delete(cityDescriptionById);
        cityRepository.delete(cityById);
    }


}
