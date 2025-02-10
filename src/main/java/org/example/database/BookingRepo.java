package org.example.database;

import org.example.models.Booking;

import java.util.HashMap;

public class BookingRepo {
    public HashMap<String, Booking> BookingTable=new HashMap<>();

    public Booking getBooking(String bid) {
        if(BookingTable.containsKey(bid)){
            return BookingTable.get(bid);
        }
        System.out.println(" BOOKING NOT PRESENT ");
        return null;
    }

    public void addBooking(Booking obj) {
        BookingTable.putIfAbsent(obj.getId(),obj);
    }

    public void deleteBooking(String bid) {
        BookingTable.remove(bid);
    }
}
