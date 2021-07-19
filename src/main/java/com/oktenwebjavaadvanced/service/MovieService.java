package com.oktenwebjavaadvanced.service;

import com.oktenwebjavaadvanced.entity.Movie;

import java.util.List;

public interface MovieService {



    List<Movie> getAllMovies();

    Movie createMvie(Movie movie);

    Movie updateMovie(int id, Movie movie);

    void deleteMovie(int id);

    Movie getMovieById(int id);

}
