package org.example.models;

import org.example.enums.BookingStatus;

import java.util.ArrayList;

public class Booking {
    private String id;
    private String customerId;
    private String showId;
    private ArrayList<String> BookedSeatsRef = new ArrayList<>(); //seatid list
    private double totalPrice;
    private BookingStatus bookingStatus;

    public Booking(String id, String customerId, String showId, ArrayList<String> seatsBooked, double totalPrice, BookingStatus bookingStatus) {
        this.id = id;
        this.customerId = customerId;
        this.showId = showId;
        this.BookedSeatsRef = seatsBooked;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public ArrayList<String> getBookedSeatsRef() {
        return BookedSeatsRef;
    }

    public void setBookedSeatsRef(ArrayList<String> bookedSeatsRef) {
        BookedSeatsRef = bookedSeatsRef;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
