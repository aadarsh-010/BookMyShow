package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Movie {
    private String id;
    private String title;
    private List<String> genre;
    private int duration;
    private String language;
    private ArrayList<String> cast = new ArrayList<>();
    private ArrayList<String> showsRunningThisMovie=new ArrayList<>();

    public Movie(String id, List<String> genre, String title, int duration, String language, ArrayList<String> cast) {
        this.id = id;
        this.genre = genre;
        this.title = title;
        this.duration = duration;
        this.language = language;
        this.cast = cast;

    }

    public ArrayList<String> getShowsRunningThisMovie() {
        return showsRunningThisMovie;
    }

    public void addshowsRunningThisMovie(String showid){
        this.showsRunningThisMovie.add(showid);
    }

    public void removeshowsRunningThisMovie(String showid){
        for (int i = 0; i < showsRunningThisMovie.size(); i++) {
            if(Objects.equals(showid, showsRunningThisMovie.get(i))){
                showsRunningThisMovie.remove(i);
            }
        }
    }




    //------------------------------------------------------------------------------------------------------------------------------------------



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }
}
