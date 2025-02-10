package org.example.repository;

import org.example.models.Theatre;

import java.util.HashMap;

public class TheatreRepository {


    public HashMap<String, Theatre> Theatredb=new HashMap<>();

    public  Theatre getTheatre(String thid) {
        if(Theatredb.containsKey(thid)){
            return Theatredb.get(thid);
        }
        System.out.println(" THEATRE NOT PRESENT ");
        return null;
    }

    public void addTheater(Theatre obj) {
        Theatredb.putIfAbsent(obj.getId(),obj);
    }

    public void deletetheater(String thid) {
        Theatredb.remove(thid);
    }



}
