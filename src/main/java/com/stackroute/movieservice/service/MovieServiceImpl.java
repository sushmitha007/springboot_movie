package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getImdbId())    ){
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteMovie(int imdbId) throws MovieNotFoundException{
        if(movieRepository.existsById(imdbId)==false) {
            throw new MovieNotFoundException("Movie not found");
        }
            movieRepository.deleteById(imdbId);
            return true;
        }

    @Override
    public Movie getMovieById(int imdbId) throws MovieNotFoundException {
        if(movieRepository.existsById(imdbId)==false)
        {
            throw new  MovieNotFoundException("Movie not found");
        }
        return movieRepository.findById(imdbId).get();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie updatedMovie =movieRepository.save(movie);
        return updatedMovie;
        }
        @Override
    public List<Movie> getBymovieTitle(String movieTitle){
        List<Movie> movieName=movieRepository.getBymovieTitle(movieTitle);
        return movieName;
    }
    }

