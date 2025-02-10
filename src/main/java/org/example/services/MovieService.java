package org.example.services;

import org.example.repository.DatabaseCollection;
import org.example.repository.MovieRepository;

import org.example.models.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieService {

    private static MovieService movieServiceObject;
    MovieRepository movietable;

    MovieService() {
        movietable = DatabaseCollection.instance().MovieTable;
    }

    public static MovieService instance() {
        if (movieServiceObject == null) movieServiceObject = new MovieService();
        return movieServiceObject;
    }

    public void createMovie(String id, List<String> genre, String title, int duration, String language, ArrayList<String> cast) {
        Movie m1 = new Movie(id, genre, title, duration, language, cast);
        movietable.addMovie(m1);
    }

    public void deleteMovie(String mid) throws Exception {
        movietable.deleteMovie(mid);
    }

    public void addShowRefToMovie(String showid , String movieid){
        movietable.getMovie(movieid).addshowsRunningThisMovie(showid);
    }

    public void removeShowRefToMovie(String showid , String movieid){
        movietable.getMovie(movieid).removeshowsRunningThisMovie(showid);
    }


    public ArrayList<String> getMoviesByName(String st1) {
        ArrayList<String> ars = new ArrayList<>();
        for (HashMap.Entry<String, Movie> set : movietable.MovieTable.entrySet()) {
            if(set.getValue().getTitle().contains(st1))ars.add(set.getValue().getTitle());
        }
        return ars;
    }
    public ArrayList<String> getMoviesByGenre(String st1) {
        ArrayList<String> ars = new ArrayList<>();
        for (HashMap.Entry<String, Movie> set : movietable.MovieTable.entrySet()) {
            boolean flag = false;
            for (int i = 0; i < set.getValue().getGenre().size() ; i++) {
                if(set.getValue().getGenre().get(i).contains(st1))flag = true;
            }
            if(flag)ars.add(set.getValue().getTitle());
        }
        return ars;
    }

    public ArrayList<String> getMoviesByCast(String st1) {
        ArrayList<String> ars = new ArrayList<>();
        for (HashMap.Entry<String, Movie> set : movietable.MovieTable.entrySet()) {
            boolean flag = false;
            for (int i = 0; i < set.getValue().getCast().size() ; i++) {
                if(set.getValue().getCast().get(i).contains(st1))flag = true;
            }
            if(flag)ars.add(set.getValue().getTitle());
        }
        return ars;
    }

    public ArrayList<String> getMoviesByLocation(String st1) {

        ArrayList<String> ars = new ArrayList<>();
        for (HashMap.Entry<String, Movie> set : movietable.MovieTable.entrySet()) {
            boolean flag = false;
            for (int i = 0; i < set.getValue().getShowsRunningThisMovie().size() ; i++) {
                String key1 =set.getValue().getShowsRunningThisMovie().get(i);
                String key2 = ShowService.instance().getAvaiableShow(key1).getTheatreId();
                if(TheaterService.instance().getTheater(key2).getLocation().contains(st1))flag = true;

            }
            if(flag)ars.add(set.getValue().getTitle());
        }
        return ars;
    }
}
