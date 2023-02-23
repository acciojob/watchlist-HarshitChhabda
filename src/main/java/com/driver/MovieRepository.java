package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {


    private HashMap<String, List<String>> movie_director;
    private HashMap<String, Movie> move;
    private HashMap<String, Director> dire;

    public MovieRepository() {
        this.movie_director = new HashMap<>();
        this.move = new HashMap<>();
        this.dire = new HashMap<>();
    }

    public String add_movie(Movie mov) {
        String name = mov.getName();
        if (!move.containsKey(name)) move.put(name, mov);

        return "Movie Added Successfully";
    }

    public String add_director(Director dir) {
        String name = dir.getName();
        if (!dire.containsKey(name)) dire.put(name, dir);

        return "Director added successfully";

    }

    public String add_movie_director_pair(String mov, String dir) {

        if (!move.containsKey(mov) || !dire.containsKey(dir)) return "Movie or Director not found in data base";

        if (movie_director.containsKey(dir)) {
            movie_director.get(dir).add(mov);
        } else {
            List<String> ans = new ArrayList<>();
            ans.add(mov);
            movie_director.put(dir, ans);
        }
        return "Movie-Director Pair added successfully";
    }

    public Movie get_movie_by_name(String Movname) {
        if (!move.containsKey(Movname)) return null;

        return move.get(Movname);
    }

    public Director get_director_by_name(String dirname) {
        if (!dire.containsKey(dirname)) return null;

        return dire.get(dirname);
    }

    public List<String> get_movies_by_director_name(String dir) {
        return movie_director.get(dir);
    }

    public List<String> get_all_movies() {
        List<String> ans = new ArrayList<>();
        for (String name : move.keySet()) {
            ans.add(name);
        }
        return ans;
    }

    public String deleteDirectorByName(String dirname) {
        List<String> e = movie_director.get(dirname);
        for (int i = 0; i < e.size(); i++) {
            if (move.containsKey(e.get(i))) {
                move.remove(e.get(i));
            }
        }
        movie_director.remove(dirname);
        if (dire.containsKey(dirname)) dire.remove(dirname);

        return "Director and its movies removed successfully";
    }

    public String deleteAllDirectors() {
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
        return "All directors and all of their movies removed successfully";
    }
}


