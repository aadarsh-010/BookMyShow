package org.example.models;


import org.example.enums.SeatType;

import java.lang.reflect.GenericArrayType;
import java.util.HashMap;

public class ScreenSeat {
    String id;
    int totalSeats;
    HashMap<org.example.enums.SeatType,Integer> seatTypeAndCount = new HashMap<>();

    public ScreenSeat(String id ,int totalSeats, HashMap<SeatType, Integer> seatTypeAndCount) {
        this.totalSeats = totalSeats;
        this.seatTypeAndCount = seatTypeAndCount;
        this.id=id;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public HashMap<SeatType, Integer> getSeatTypeAndCount() {
        return seatTypeAndCount;
    }

    public void setSeatTypeAndCount(HashMap<SeatType, Integer> seatTypeAndCount) {
        this.seatTypeAndCount = seatTypeAndCount;
    }
}
