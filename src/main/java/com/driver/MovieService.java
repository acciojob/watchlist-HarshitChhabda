package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {
    @Autowired
    MovieRepository repo;
    public String add_movie(Movie mov) {
        return repo.add_movie(mov);
    }
    public String add_director(Director dir) {
      return repo.add_director(dir);
    }

    public String add_movie_director_pair(String mov, String dir) {
       return repo.add_movie_director_pair(mov,dir);
    }

    public Movie get_movie_by_name(String movName) {
       return repo.get_movie_by_name(movName);
    }

    public Director get_director_by_name(String dirName) {
        return repo.get_director_by_name(dirName);
    }

    public List<String> get_movies_by_director_name(String dir) {
       return repo.get_movies_by_director_name(dir);
    }

    public List<String> get_all_movies() {
        return repo.get_all_movies();
    }

    public String deleteDirectorByName(String Dirname)
    {
        return repo.deleteDirectorByName(Dirname);
    }
    public String deleteAllDirectors()
    {
        return repo.deleteAllDirectors();
    }
}
