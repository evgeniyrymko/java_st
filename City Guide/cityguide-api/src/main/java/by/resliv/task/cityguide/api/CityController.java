package by.resliv.task.cityguide.api;

import by.resliv.task.cityguide.dto.CityDto;
import by.resliv.task.cityguide.mapper.CityMapper;
import by.resliv.task.cityguide.model.City;
import by.resliv.task.cityguide.model.CityDescription;
import by.resliv.task.cityguide.repository.CityDescriptionRepository;
import by.resliv.task.cityguide.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {

    private CityRepository cityRepository;

    private CityDescriptionRepository cityDescriptionRepository;

    private CityMapper cityMapper;

    @Autowired
    public CityController(CityRepository cityRepository, CityDescriptionRepository cityDescriptionRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityDescriptionRepository = cityDescriptionRepository;
        this.cityMapper = cityMapper;
    }

    @GetMapping("/all")
    public List<CityDto> getAllCities() {
        List<City> allCities = this.cityRepository.findAll();
        List<CityDto> allCitiesDto = allCities.stream()
                .map(city -> this.cityMapper.convertToCityDto(city))
                .collect(Collectors.toList());
        return allCitiesDto;
    }

    @GetMapping("/byId/{id}")
    public CityDto getCityById(@PathVariable long id) {
        Optional<City> optionalCityRepositoryById = this.cityRepository.findById(id);

        if (!optionalCityRepositoryById.isPresent()) {
            throw new EntityNotFoundException();
        }

        CityDto cityDtoById = this.cityMapper.convertToCityDto(optionalCityRepositoryById.get());

        return cityDtoById;
    }

    @PostMapping
    public City saveCity(@RequestBody CityDto cityDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            try {
                throw new ValidationException("An error occurred while saving new city");
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }

        City city = this.cityMapper.convertToCity(cityDto);
        cityDescriptionRepository.save(city.getCityDescription());
        cityRepository.save(city);

        return city;
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable long id) {
        City cityById = this.cityRepository.findById(id).get();
        CityDescription cityDescriptionById = cityById.getCityDescription();
        cityDescriptionRepository.delete(cityDescriptionById);
        cityRepository.delete(cityById);

    }


}
