package by.rymko.task.libraryapi.api;

import by.rymko.task.libraryapi.dto.GenreDto;
import by.rymko.task.libraryapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("api/genres")
@CrossOrigin
public class GenreController {

    private GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/all")
    public List<GenreDto> getAllGenres() {
        return this.genreService.getAllGenres();
    }

    @GetMapping("/byId/{id}")
    public GenreDto getGenreById(@PathVariable long id) {
        return this.genreService.getGenreById(id);
    }

    @PostMapping
    public GenreDto saveUpdateGenre(@RequestBody GenreDto genreDto,
                                    BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) throw new ValidationException("An error has occurred while saving a genre");
        GenreDto updatedGenreDto = this.genreService.saveUpdateGenre(genreDto);
        return updatedGenreDto;
    }

    @DeleteMapping("/{id}")
    public void deleteGenreById(@PathVariable long id) {
        this.genreService.deleteGenreById(id);
    }
}
