package org.example.repository;


import org.example.models.Seat;

import java.util.HashMap;

public class SeatRepository {

    public HashMap<String,Seat> Seatdb=new HashMap<>();


    public Seat getSeat(String sid) {
        if(Seatdb.containsKey(sid)){
            return Seatdb.get(sid);
        }
        System.out.println(" Seat NOT PRESENT ");
        return null;
    }

    public void addSeat(Seat obj) {
        Seatdb.putIfAbsent(obj.getId(),obj);
    }

    public void deleteSeat(String sid) {
        Seatdb.remove(sid);
    }


}
