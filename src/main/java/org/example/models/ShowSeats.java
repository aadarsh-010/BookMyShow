package org.example.models;

import org.example.enums.SeatType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ShowSeats extends ScreenSeat {
    private String showseatsid;
    HashMap<org.example.enums.SeatType,Integer> PricePerSeatType=new HashMap<>();
    private ArrayList<String> showSeatsRef=new ArrayList<>();

    public ShowSeats(String id, HashMap<SeatType, Integer> pricePerSeatType,ScreenSeat obj1) {

        super(obj1.id,obj1.totalSeats,obj1.seatTypeAndCount);
        this.id = id;
        PricePerSeatType = pricePerSeatType;
        this.showSeatsRef = showSeatsRef;
    }

    public void addshowSeatsRef(String seatid){
        this.showSeatsRef.add(seatid);
    }

    public void removeshowSeatsRef(String seatid){
        for (int i = 0; i < showSeatsRef.size(); i++) {
            if(Objects.equals(seatid, showSeatsRef.get(i))){
                showSeatsRef.remove(i);
            }
        }
    }






    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<SeatType, Integer> getPricePerSeatType() {
        return PricePerSeatType;
    }

    public void setPricePerSeatType(HashMap<SeatType, Integer> pricePerSeatType) {
        PricePerSeatType = pricePerSeatType;
    }

    public ArrayList<String> getShowSeatsRef() {
        return showSeatsRef;
    }

    public void setShowSeatsRef(ArrayList<String> showSeatsRef) {
        this.showSeatsRef = showSeatsRef;
    }
}
