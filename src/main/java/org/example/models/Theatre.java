package org.example.models;

import java.util.ArrayList;
import java.util.Objects;

public class Theatre {
    private String id;
    private String name;
    private String location;
    private String ownerId;
    private ArrayList<String> showsInTheatreRef=new ArrayList<>();
    private ArrayList<String> screensRef=new ArrayList<>();

    public Theatre(String id, String name, String location, String ownerId) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.ownerId = ownerId;
    }

    public ArrayList<String> getScreen() {
        return null;
    }

    public void addScreenInTheatre(String screenid){
        this.screensRef.add(screenid);
    }

    public void removeScreenInTheatre(String screenid){
        for (int i = 0; i < screensRef.size(); i++) {
            if(Objects.equals(screenid, screensRef.get(i))){
                screensRef.remove(i);
            }
        }
    }

    public void addShowInTheatre(String showid){
        this.showsInTheatreRef.add(showid);
    }

    public void removeShowInTheatre(String showid){
        for (int i = 0; i < showsInTheatreRef.size(); i++) {
            if(Objects.equals(showid, showsInTheatreRef.get(i))){
                showsInTheatreRef.remove(i);
            }
        }
    }



    //.......................................................................
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }





}
