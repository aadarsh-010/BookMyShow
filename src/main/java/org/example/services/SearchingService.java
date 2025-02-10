package org.example.services;

import java.util.ArrayList;

public class SearchingService {

    public ArrayList<String> getMoviesByName(String st1){

        return MovieService.instance().getMoviesByName(st1);


    }
    public ArrayList<String> getMoviesByCast(String st1){
        return MovieService.instance().getMoviesByCast(st1);
    }

    public ArrayList<String> getMoviesByGenre(String st1){
        return MovieService.instance().getMoviesByCast(st1);
    }

    public ArrayList<String> getMoviesByLocation(String st1){
        return MovieService.instance().getMoviesByLocation(st1);
    }

}
