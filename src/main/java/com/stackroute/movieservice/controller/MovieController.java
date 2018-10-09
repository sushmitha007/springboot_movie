package com.stackroute.movieservice.controller;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.service.MovieService;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
@Api(value="movieapp", description="Operations pertaining to Movie App")
public class MovieController {
//    @Autowired
//     @Qualifier("MovieServieImpl2")
    MovieService movieService;

    @Autowired

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @ApiOperation(value = "Create movie list")
    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        try {
            movieService.saveMovie(movie);
            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @ApiOperation(value = "View a list of available movie")
    @GetMapping("movies")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }
    @ApiOperation(value = "Delete a movie")
    @RequestMapping(value = "movie/{imdbId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMovie(@PathVariable("imdbId") int imdbId) throws MovieNotFoundException{

        Movie movieName;
        try {
            movieName = movieService.getMovieById(imdbId);
        }
        catch (MovieNotFoundException ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        movieService.deleteMovie(imdbId);
        return new ResponseEntity<String>("movie deleted successfully", HttpStatus.OK);


    }
    @ApiOperation(value = "Update movie")
    @PutMapping("/movies/{imdbId}")
    public ResponseEntity<?> update(@RequestBody Movie movie, @PathVariable int imdbId)throws MovieNotFoundException {
      Movie movieName;
        try {
            movieName = movieService.getMovieById(imdbId);
        }
        catch (MovieNotFoundException ex) {
          return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }

            movieName.setMovieTitle(movie.getMovieTitle());
            movieName.setPosterUrl(movie.getPosterUrl());
            movieName.setComment(movie.getComment());
            movieName.setRating(movie.getRating());
            movieName.setYearOfRelease(movie.getYearOfRelease());
        movieService.updateMovie(movieName);
        return new ResponseEntity<Movie>(movieName, HttpStatus.OK);
    }
    @ApiOperation(value = "View a list of same Title")
    @GetMapping("/movies/{name}")
    public ResponseEntity<?> searchByName(@PathVariable("name") String movieTitle) {
        return new ResponseEntity<List<Movie>>((List<Movie>) movieService.getBymovieTitle(movieTitle),HttpStatus.OK);
    }

}
