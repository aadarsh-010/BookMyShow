package org.example.services;

import org.example.repository.DatabaseCollection;
import org.example.repository.ScreenRepository;
import org.example.enums.SeatType;
import org.example.models.Screen;
import org.example.models.ScreenSeat;

import java.util.HashMap;

public class ScreenService {


    private static ScreenService screenServiceObject;
    ScreenRepository screenTable;

    ScreenService() {
        this.screenTable = DatabaseCollection.instance().ScreenTable;
    }

    public static ScreenService instance() {
        if (screenServiceObject == null) screenServiceObject = new ScreenService();
        return screenServiceObject;
    }


    public void CreateScreenSeats(String id ,int totalSeats, HashMap<SeatType, Integer> seatTypeAndCount){

        ScreenSeat sc1 = new ScreenSeat(id,totalSeats,seatTypeAndCount);
        screenTable.ScreenSeatTable.putIfAbsent(id,sc1);

    }
    public void CreateScreen(String id, String theatreid,String screenSeatID ,int totalSeats, HashMap<SeatType,Integer> seatTypeAndCount ){

        Screen obj1 = new Screen(id,theatreid,screenSeatID);
        screenTable.ScreenTable.putIfAbsent(id,obj1);
        CreateScreenSeats(screenSeatID,totalSeats,seatTypeAndCount);
        addScreenToTheatre(theatreid,id);

    }

    public ScreenSeat getScreenSeat(String screenid){
        String x=screenTable.getScreen(screenid).getScreenSeatID();
        return screenTable.getScreenSeat(x);
    }

    public void addScreenToTheatre(String Theatreid, String Screenid) {
        TheaterService.instance().addScreenInTheater(Theatreid,Screenid);

    }

    public void removeScreenToTheatre(String Theatreid, String Screenid) {
        TheaterService.instance().removeScreenInTheater(Theatreid,Screenid);
    }

    public void addShowToScreen(String shwid, String Screenid) {
        screenTable.getScreen(Screenid).addShowInScreen(shwid);

    }

    public void removeShowToScreen(String shwid, String Screenid) {
        screenTable.getScreen(Screenid).removeShowInScreen(shwid);
    }

    public void DeleteScreen(String sid){

        for (int i = 0; i <screenTable.getScreen(sid).getShowRef().size() ; i++) {
            ShowService.instance().DeleteShow(screenTable.getScreen(sid).getShowRef().get(i));
        }
            removeScreenToTheatre(screenTable.getScreen(sid).getTheatreid(),sid);
            screenTable.deleteScreenSeat(screenTable.getScreen(sid).getScreenSeatID()); // delete krra hu screenseat bhi
            screenTable.deleteScreen(sid);
    }





}
