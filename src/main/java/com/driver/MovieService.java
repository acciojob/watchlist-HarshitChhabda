package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {
    @Autowired
    MovieRepository repo;
    public void add_movie(Movie mov) {
        repo.add_movie(mov);
    }
    public void add_director(Director dir) {
      repo.add_director(dir);
    }

    public void add_movie_director_pair(String dire, String mov) {
       repo.add_movie_director_pair(dire,mov);
    }

    public Movie get_movie_by_name(String name) {
       return repo.get_movie_by_name(name);
    }

    public Director get_director_by_name(String name) {
        return repo.get_director_by_name(name);
    }

    public List<String> get_movies_by_director_name(String dir) {
       return repo.get_movies_by_director_name(dir);
    }

    public List<String> get_all_movies() {
        return repo.get_all_movies();
    }

    public void deleteDirectorByName(String Dirname)
    {
        repo.deleteDirectorByName(Dirname);
    }
    public void deleteAllDirectors()
    {
        repo.deleteAllDirectors();
    }
}
