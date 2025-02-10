package org.example.services;

import org.example.database.DatabaseCollection;
import org.example.database.SeatRepo;

import org.example.database.ShowRepo;

import org.example.enums.SeatBookingStatus;
import org.example.enums.SeatType;
import org.example.models.Seat;
import org.example.models.Show;
import org.example.models.ShowSeats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ShowService {

    public static int globalseatid = 1;

    private static ShowService ShowServiceObject;
    ShowRepo showTable;
    SeatRepo seatTable;

    ShowService() {
        this.showTable = DatabaseCollection.instance().ShowTable;
        this.seatTable = DatabaseCollection.instance().SeatTable;
    }

    public static ShowService instance() {
        if (ShowServiceObject == null) ShowServiceObject = new ShowService();
        return ShowServiceObject;
    }


    public void CreateShow(String id, String movieId, String theatreId, String screenId, String startTime, String endTime, String showSeatRefid, HashMap<org.example.enums.SeatType, Integer> PricePerSeatType) {


        Show s1 = new Show(id, movieId, theatreId, screenId, startTime, endTime, showSeatRefid);
        ShowSeats s2 = new ShowSeats(showSeatRefid, PricePerSeatType, ScreenService.instance().getScreenSeat(screenId));
        showTable.Showdb.putIfAbsent(id, s1);
        showTable.addshowSeat(s2);
        addshowtoScreen(id);
        addshowtoTheatre(id);showTable.Showdb.putIfAbsent(id, s1);
        showTable.addshowSeat(s2);
        addshowtoScreen(id);
        addshowtoTheatre(id);
        generateSeats(id,PricePerSeatType , ScreenService.instance().getScreenSeat(screenId).getSeatTypeAndCount(),showSeatRefid);
        addShowRefToMovie(id,movieId);

    }
    public void generateSeats(String showid,HashMap<org.example.enums.SeatType, Integer> PricePerSeatType,HashMap<org.example.enums.SeatType,Integer> seatTypeAndCount, String showSeatRefid){
        for(Map.Entry<SeatType, Integer> mapElement : seatTypeAndCount.entrySet()){
            for (int i = 0; i < mapElement.getValue(); i++) {
                Seat obj = new Seat(Integer.toString(globalseatid), SeatBookingStatus.Open,mapElement.getKey(),showid,PricePerSeatType.get(mapElement.getKey()));
                globalseatid++;
                seatTable.addSeat(obj);
                String x =showSeatRefid;
                showTable.getshowSeat(x).addshowSeatsRef(obj.getId()); //adding seatref overthere;
            }
        }
    };


    public void DeleteShow(String showid) {
        //delete seat ref
        Show s1 = showTable.getShow(showid);
        removeshowtoScreen(showid);
        removeshowtoTheatre(showid);
        showTable.deleteshowSeat(s1.getShowSeatRef());
        showTable.deleteShow(showid);
    }

    public void addshowtoTheatre(String showid) {
        TheaterService.instance().addShowInTheater(showTable.getShow(showid).getTheatreId(), showid);
    }

    public void addshowtoScreen(String showid) {
        ScreenService.instance().addShowToScreen(showid, showTable.getShow(showid).getScreenId());
    }

    public void removeshowtoTheatre(String showid) {
        TheaterService.instance().removeShowInTheater(showTable.getShow(showid).getTheatreId(), showid);
    }

    public void removeshowtoScreen(String showid) {
        ScreenService.instance().removeShowToScreen(showid, showTable.getShow(showid).getScreenId());
    }



    public void addShowRefToMovie(String showid, String mid){
        MovieService.instance().addShowRefToMovie(showid,mid);
    }


    public int getAvaiableSeats(String showid, SeatType st) {
        int seatsaval=0;
        String x = showTable.getShow(showid).getShowSeatRef();
        ArrayList<String> seats = showTable.getshowSeat(x).getShowSeatsRef();

        for(int i = 0; i < seats.size(); i++) {
                if(st == seatTable.getSeat(seats.get(i)).getSeatType() && seatTable.getSeat(seats.get(i)).getSeatBookingStatus()==SeatBookingStatus.Open){
                        seatsaval++;
                }
        }
        return seatsaval;
    }


    public Show getAvaiableShow(String key1) {
        return showTable.getShow(key1);
    }
}
