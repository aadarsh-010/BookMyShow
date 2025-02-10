package org.example.repository;

import org.example.models.Show;
import org.example.models.ShowSeats;

import java.util.HashMap;

public class ShowRepository {

    public HashMap<String, Show> Showdb=new HashMap<>();
    public HashMap<String, ShowSeats> showSeatdb=new HashMap<>();


    public Show getShow(String sid) {
        if(Showdb.containsKey(sid)){
            return Showdb.get(sid);
        }
        System.out.println(" SCREEN NOT PRESENT ");
        return null;
    }

    public void addShow(Show obj) {
        Showdb.putIfAbsent(obj.getId(),obj);
    }

    public void deleteShow(String showid) {
            Showdb.remove(showid);
    }



    public ShowSeats getshowSeat(String sid) {
        if(showSeatdb.containsKey(sid)){
            return showSeatdb.get(sid);
        }
        System.out.println(" showseat NOT PRESENT ");
        return null;
    }

    public void addshowSeat(ShowSeats obj) {
        showSeatdb.putIfAbsent(obj.getId(),obj);
    }

    public void deleteshowSeat(String showseatid) {
        showSeatdb.remove(showseatid);
    }
}
