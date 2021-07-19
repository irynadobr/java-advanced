package com.oktenwebjavaadvanced.controller;

import com.oktenwebjavaadvanced.entity.Movie;
import com.oktenwebjavaadvanced.service.MovieService;
import com.oktenwebjavaadvanced.validator.MovieValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping (value = "/movie")
public class MovieController {
    @Autowired
   private MovieService movieService;

    @Autowired
    private MovieValidator movieValidator;
//    @RequestMapping(value = "/movie",method = RequestMethod.GET)
    @GetMapping
    public List<Movie>getMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping ("/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  Movie insertMovie (@RequestBody @Valid Movie movie) {
        return movieService.createMvie(movie);
    }

@PutMapping(value = "/{id}")
@ResponseStatus(HttpStatus.ACCEPTED)
public Movie updateMovie (@PathVariable int id, @RequestBody @Valid Movie movie) {
        return movieService.updateMovie(id, movie);
}
@DeleteMapping(value = "/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteMovie (@PathVariable int id) {
        movieService.deleteMovie(id);

}
//@InitBinder
// public void initBinder (WebDataBinder dataBinder) {
//        dataBinder.addValidators(movieValidator);
//}
}
