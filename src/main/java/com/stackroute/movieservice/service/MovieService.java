package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;

import java.util.List;
public interface MovieService {
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;

    public List<Movie> getAllMovies();

    public Movie updateMovie(Movie movie);

    public boolean deleteMovie(int imdbId) throws MovieNotFoundException;

   //public Optional<Movie> findById(int imdbId);

   public Movie getMovieById(int imdbId) throws MovieNotFoundException;
    public List<Movie> getBymovieTitle(String movieTitle);
}
