//package com.stackroute.movieservice.service;
//
//import com.stackroute.movieservice.domain.Movie;
//import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
//import com.stackroute.movieservice.exceptions.MovieNotFoundException;
//import com.stackroute.movieservice.repository.MovieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class MovieServiceImpl2 implements MovieService {
//    MovieRepository movieRepository;
//
//    @Autowired
//    public MovieServiceImpl2(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }
//
//    @Override
//    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
//        if(movieRepository.existsById(movie.getImdbId())    ){
//            throw new MovieAlreadyExistsException("Movie already exists");
//        }
//        Movie savedMovie = movieRepository.save(movie);
//        return savedMovie;
//    }
//
//    @Override
//    public List<Movie> getAllMovies() {
//        return movieRepository.findAll();
//    }
//
//    @Override
//    public Movie updateMovie(Movie movie) {
//        return null;
//    }
//
//    @Override
//    public boolean deleteMovie(int imdbId) throws MovieNotFoundException {
//        return false;
//    }
//
//    @Override
//    public Movie getMovieById(int imdbId) throws MovieNotFoundException {
//        return null;
//    }
//
//    @Override
//    public List<Movie> getBymovieTitle(String movieTitle) {
//        return null;
//    }
//
//}
