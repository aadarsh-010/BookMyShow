package org.example.models.user;

import java.util.ArrayList;
import java.util.Objects;

public class Customer extends User{
    private ArrayList<String> userBookings=new ArrayList<>();


    public Customer(String id, String name, String email, String phoneNumber) {
        super(id,name,email,phoneNumber);
    }


    //------------------------------------------------------
    public ArrayList<String> getUserBookings() {
        return userBookings;
    }


    public void setUserBookings(String bid) {
        this.userBookings.add(bid);
    }

    public void removeUserBookings(String bid) {
        for (int i = 0; i < this.userBookings.size(); i++) {
            if(Objects.equals(bid, userBookings.get(i))){
                userBookings.remove(i);
            }
        }
    }
}
