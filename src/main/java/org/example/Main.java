package org.example;

import org.example.enums.BookingStatus;
import org.example.enums.SeatType;
import org.example.services.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

            // create creator - 2

        UserService.instance().createUser("c1","adi","adi@gmail.com","9770943003","CREATOR");
        UserService.instance().createUser("c2","sanya","sanya@gmail.com","8870983003","CREATOR");
           // create user  - 2
        UserService.instance().createUser("u1","shashank","shashank@gmail.com","9770943003","CUSTOMER");
        UserService.instance().createUser("u2","shubham","shubham@gmail.com","8870983003","CUSTOMER");

            // add theatre

        TheaterService.instance().CreateTheater("c1-th1","vasant Talkies","bhilai","c1");
        TheaterService.instance().CreateTheater("c2-th1","PVR","Nehru Nagar","c2");

        // add screen
        HashMap<SeatType,Integer> seattypecount = new HashMap<>();
        seattypecount.putIfAbsent(SeatType.GOLD,30);
        seattypecount.putIfAbsent(SeatType.SILVER,30);
        seattypecount.putIfAbsent(SeatType.DIAMOND,20);
        seattypecount.putIfAbsent(SeatType.BALCONY,20);

        ScreenService.instance().CreateScreen("c1-th1-sc1","c1-th1","c1-th1-ssc1",100,seattypecount);


        ScreenService.instance().CreateScreen("c2-th1-sc1","c2-th1","c2-th1-ssc1",100,seattypecount);

        // add movie
        List<String> genre1 = new ArrayList<>();
        genre1.add("comedy");
        genre1.add("Horror");

        ArrayList<String> cast1 = new ArrayList<>();
        cast1.add("Shraddha Kapoor");
        cast1.add("Rajkumar Rao");

        MovieService.instance().createMovie("m1",genre1,"Stree 2",200000,"Hindi",cast1);



        // add show

        HashMap<SeatType,Integer> ppst = new HashMap<>();
        ppst.putIfAbsent(SeatType.GOLD,400);
        ppst.putIfAbsent(SeatType.SILVER,300);
        ppst.putIfAbsent(SeatType.DIAMOND,500);
        ppst.putIfAbsent(SeatType.BALCONY,600);
        ShowService.instance().CreateShow("s1","m1","c1-th1","c1-th1-sc1","17:00","20:00","s1-ssr1",ppst);

        HashMap<SeatType,Integer> ppsts = new HashMap<>();
        ppsts.putIfAbsent(SeatType.GOLD,400);
        ppsts.putIfAbsent(SeatType.SILVER,300);
        ppsts.putIfAbsent(SeatType.DIAMOND,500);
        ppsts.putIfAbsent(SeatType.BALCONY,600);
        ShowService.instance().CreateShow("s2","m1","c2-th1","c2-th1-sc1","17:00","20:00","s2-ssr1",ppsts);


            // book show

        ArrayList<String> seatbook = new ArrayList<>();
        seatbook.add("10");
        seatbook.add("11");


        BookingService.instance().bookShow("b1","u1","s1",seatbook,900, BookingStatus.Confirmed);//dlboking



    }
}






