package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {


    private HashMap<String, List<String>> movie_director = new HashMap<>();
    private HashMap<String, Movie> move = new HashMap<>();
    private HashMap<String, Director> dire = new HashMap<>();

    public void add_movie(Movie mov) {
        move.put(mov.getName(), mov);
    }

    public void add_director(Director dir) {
        dire.put(dir.getName(), dir);
    }

    public void add_movie_director_pair(String mov, String dir) {

        if (move.containsKey(mov) && dire.containsKey(dir)) {
            List<String> current = new ArrayList<>();
            if (movie_director.containsKey(dir)) current = movie_director.get(dir);
            current.add(mov);
            movie_director.put(dir, current);
        }
    }

    public Movie get_movie_by_name(String Movname) {
        return move.get(Movname);
    }

    public Director get_director_by_name(String dirname) {
        return dire.get(dirname);
    }

    public List<String> get_movies_by_director_name(String dir) {
        List<String> movieList = new ArrayList<>();
        if (movie_director.containsKey(dir)) {
            movieList = movie_director.get(dir);
        }
        return movieList;
    }

    public List<String> get_all_movies() {
        return new ArrayList<>(move.keySet());
    }

    public void deleteDirectorByName(String dirname) {
        List<String> e = movie_director.get(dirname);
        for (int i = 0; i < e.size(); i++) {
            if (move.containsKey(e.get(i))) {
                move.remove(e.get(i));
            }
        }
        movie_director.remove(dirname);
        if (dire.containsKey(dirname)) dire.remove(dirname);
    }

    public void deleteAllDirectors() {
        for (String che : movie_director.keySet()) {
            List<String> a = movie_director.get(che);
            for (String name : a) {
                if (move.containsKey(a)) move.remove(a);
            }
            dire.remove(che);
        }
        for (String dd : dire.keySet()) {
            dire.remove(dd);
        }
    }
}


