package org.example.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Screen {

    private String id;
    private String theatreid;
    private String screenSeatID;

    private ArrayList<String> showRef=new ArrayList<>();


    public Screen(String id, String theatreid ,String screenSeatID) {
        this.id = id;
        this.theatreid = theatreid;
        this.screenSeatID = screenSeatID;
    }

    public void addShowInScreen(String showid){
        this.showRef.add(showid);
    }

    public void removeShowInScreen(String showid){
        for (int i = 0; i < showRef.size(); i++) {
            if(Objects.equals(showid, showRef.get(i))){
                showRef.remove(i);
            }
        }
    }

    public List<Show> getScreens(){
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheatreid() {
        return theatreid;
    }

    public void setTheatreid(String theatreid) {
        this.theatreid = theatreid;
    }

    public String getScreenSeatID() {
        return screenSeatID;
    }

    public void setScreenSeatID(String screenSeatID) {
        this.screenSeatID = screenSeatID;
    }

    public ArrayList<String> getShowRef() {
        return showRef;
    }

    public void setShowRef(ArrayList<String> showRef) {
        this.showRef = showRef;
    }
}

