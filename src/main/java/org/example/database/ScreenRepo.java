package org.example.database;

import org.example.models.Screen;
import org.example.models.ScreenSeat;
import org.example.models.Theatre;

import java.util.HashMap;

public class ScreenRepo {
    public HashMap<String, Screen> ScreenTable=new HashMap<>();
    public HashMap<String, ScreenSeat> ScreenSeatTable=new HashMap<>();

    public Screen getScreen(String sid) {
        if(ScreenTable.containsKey(sid)){
            return ScreenTable.get(sid);
        }
        System.out.println(" SCREEN NOT PRESENT ");
        return null;
    }

    public void addScreen(Screen obj) {
        ScreenTable.putIfAbsent(obj.getId(),obj);
    }

    public void deleteScreen(String thid) {
        ScreenTable.remove(thid);
    }

    public  ScreenSeat getScreenSeat(String ssid) {
        if(ScreenSeatTable.containsKey(ssid)){
            return ScreenSeatTable.get(ssid);
        }
        System.out.println(" SCREEN-SEAT NOT PRESENT ");
        return null;
    }

    public  ScreenSeat addScreenSeat(String ssid) {
        if(ScreenSeatTable.containsKey(ssid)){
            return ScreenSeatTable.get(ssid);
        }
        System.out.println(" SCREEN-SEAT NOT PRESENT ");
        return null;
    }

    public void deleteScreenSeat(String ssid) {
        ScreenSeatTable.remove(ssid);
    }
}
