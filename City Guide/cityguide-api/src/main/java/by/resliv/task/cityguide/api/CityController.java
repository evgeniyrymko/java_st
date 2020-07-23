package by.resliv.task.cityguide.api;

import by.resliv.task.cityguide.dto.CityDto;
import by.resliv.task.cityguide.model.City;
import by.resliv.task.cityguide.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/all")
    public List<CityDto> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/byId/{id}")
    public CityDto getCityById(@PathVariable long id) {
        return cityService.getCityById(id);
    }

    @PostMapping("/new")
    public City addCity(@RequestBody CityDto cityDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            try {
                throw new ValidationException("An error occurred while saving new city");
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }
        return cityService.addCity(cityDto);
    }

    @PostMapping("/update-city")
    public City updateCity(@RequestBody CityDto cityDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            try {
                throw new ValidationException("An error occurred while saving new city");
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }
        return cityService.updateCity(cityDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable long id) {
        cityService.deleteCity(id);
    }


}
