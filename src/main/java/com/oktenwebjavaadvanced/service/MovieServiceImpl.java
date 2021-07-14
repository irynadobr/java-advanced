package com.oktenwebjavaadvanced.service;

import com.oktenwebjavaadvanced.dao.MovieDao;
import com.oktenwebjavaadvanced.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService  {
@Autowired
    private  MovieDao movieDao;
    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    @Override
    public Movie createMvie(Movie movie) {
        return movieDao.saveAndFlush(movie);
    }

    @Override
    public Movie updateMovie(int id, Movie movie) {
        movie.setId(id);
        if (!movieDao.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found");
        }
        return movieDao.saveAndFlush(movie);
    }

    @Override
    public void deleteMovie(int id) {
        if (!movieDao.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No movie found");
        }
        movieDao.deleteById(id);

    }
}
