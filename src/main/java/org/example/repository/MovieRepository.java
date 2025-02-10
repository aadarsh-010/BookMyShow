package org.example.repository;


import org.example.models.Movie;

import java.util.HashMap;

public class MovieRepository {

    public HashMap<String, Movie> MovieTable=new HashMap<>();

    public Movie getMovie(String mid) {
        if(MovieTable.containsKey(mid)){
            return MovieTable.get(mid);
        }
        System.out.println(" MOVIE NOT PRESENT ");
        return null;
    }

    public void addMovie(Movie obj) {
        MovieTable.putIfAbsent(obj.getId(),obj);
    }

    public void deleteMovie(String mid) {
        MovieTable.remove(mid);
    }


}
