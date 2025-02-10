package org.example.models.user;

import java.util.ArrayList;
import java.util.Objects;

public class Creator extends User {
    private ArrayList<String> theatresOwned= new ArrayList<>();


    public Creator(String id, String name, String email, String phoneNumber) {
        super(id, name, email, phoneNumber);

    }

    //------------------------------------------------------

    public ArrayList<String> getTheatresOwned() {
        return theatresOwned;
    }

    public void setTheatresOwned(String thid) {
        this.theatresOwned.add(thid);
    }

    public void removeTheatresOwned(String thid) {
        for (int i = 0; i < this.theatresOwned.size(); i++) {
            if(Objects.equals(thid, theatresOwned.get(i))){
                theatresOwned.remove(i);
            }
        }
    }

}
