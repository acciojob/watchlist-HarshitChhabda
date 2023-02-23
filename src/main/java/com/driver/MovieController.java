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
        ser.add_movie(mov);
        return new ResponseEntity<>("New Movie Added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director dir) {
        ser.add_director(dir);
        return new ResponseEntity<>("New Director Added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movName") String mov, @RequestParam("dirName") String dir) {
        ser.add_movie_director_pair(mov, dir);
        return new ResponseEntity<>("Movie And Director Pair Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name) {

        return new ResponseEntity<>(ser.get_movie_by_name(name), HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(ser.get_director_by_name(name), HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String name) {

        return new ResponseEntity<>(ser.get_movies_by_director_name(name), HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {

        return new ResponseEntity<>(ser.get_all_movies(), HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String Dirname) {
        ser.deleteDirectorByName(Dirname);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors() {
        ser.deleteAllDirectors();
        return new ResponseEntity<>("Deleted Successfully!", HttpStatus.CREATED);
    }
}
