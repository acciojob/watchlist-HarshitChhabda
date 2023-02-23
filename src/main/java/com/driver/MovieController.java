package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService ser;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie mov) {
        String res = ser.add_movie(mov);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director dir) {
        String res = ser.add_director(dir);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movName") String mov, @RequestParam("dirName") String dir) {
        String res = ser.add_movie_director_pair(mov, dir);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name) {
        Movie res = ser.get_movie_by_name(name);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name) {
        Director res = ser.get_director_by_name(name);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director) {
        List<String> res = ser.get_movies_by_director_name(director);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies() {
        List<String> res = ser.get_all_movies();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String Dirname) {
        String res = ser.deleteDirectorByName(Dirname);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors() {
        String res = ser.deleteAllDirectors();
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
