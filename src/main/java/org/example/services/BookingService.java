package org.example.services;

import org.example.repository.BookingRepository;

import org.example.repository.DatabaseCollection;
import org.example.repository.SeatRepository;

import org.example.enums.BookingStatus;
import org.example.enums.SeatBookingStatus;
import org.example.models.Booking;
import org.example.services.paymentservice.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BookingService {


    public static int BookingID = 0;
    private static BookingService bookingServiceObject;
    BookingRepository bookingtable;
    SeatRepository seatTable;

    BookingService() {
        bookingtable = DatabaseCollection.instance().BookingTable;
        this.seatTable = DatabaseCollection.instance().SeatTable;
    }

    public static BookingService instance() {
        if (bookingServiceObject == null) bookingServiceObject = new BookingService();
        return bookingServiceObject;
    }

    public synchronized void bookShow(String id, String customerId, String showId, ArrayList<String> seatsBooked, double totalPrice, BookingStatus bookingStatus) throws Exception {
        boolean check = true;


        for (int i = 0; i < seatsBooked.size(); i++) {
            if (seatTable.getSeat(seatsBooked.get(i)).getSeatBookingStatus() != SeatBookingStatus.Open) {
                check = false;
            }
        }
        int totalprice = 0;


        if (check) {

            for (int i = 0; i < seatsBooked.size(); i++) {
                seatTable.getSeat(seatsBooked.get(i)).setSeatBookingStatus(SeatBookingStatus.Reserved);
                totalprice +=  seatTable.getSeat(seatsBooked.get(i)).getPrice();
            }



            //PaymentService----------------------------------------

            System.out.println("SELECT PAYMENT METHOD :  CARD / DEBIT / UPI");
            Scanner sc = new Scanner( System.in);
            String input = sc.next();

            if(Objects.equals(input, "CARD")){
                System.out.println("enter card number");
                String cardnum = sc.next();
                CreditCard c1 = new CreditCard(cardnum);
                PaymentService ps = new PaymentService(c1);
                ps.pay(totalprice);
            }
            else if (Objects.equals(input, "DEBIT")){
                System.out.println("enter debit number");
                String cardnum = sc.next();
                DebitCard c1 = new DebitCard(cardnum);
                PaymentService ps = new PaymentService(c1);
                ps.pay(totalprice);
            }else if (Objects.equals(input, "UPI")){
                System.out.println("enter upi number");
                String upi = sc.next();
                UPI c1 = new UPI(upi);
                PaymentService ps = new PaymentService(c1);
                ps.pay(totalprice);
            }
            else {
                System.out.println("invalid payment method");
            }



            for (int i = 0; i < seatsBooked.size(); i++) {
                seatTable.getSeat(seatsBooked.get(i)).setSeatBookingStatus(SeatBookingStatus.Booked);
                totalprice +=  seatTable.getSeat(seatsBooked.get(i)).getPrice();
            }


            Booking b1 = new Booking(Integer.toString(BookingID),customerId,showId,seatsBooked,totalPrice,BookingStatus.Confirmed);
            bookingtable.addBooking(b1);
            BookingID++;
            UserService.instance().addUserBookings(customerId,b1.getId());




            System.out.println("Booked " + seatsBooked.size() + " for price total " + totalPrice);
        } else {
            System.out.println("Not enough tickets available to book ");
        }
    }

    public void cancelBooking(String bid) {
        ArrayList<String> as= bookingtable.getBooking(bid).getBookedSeatsRef();
        for (int i = 0; i < as.size(); i++) {
            seatTable.getSeat(as.get(i)).setSeatBookingStatus(SeatBookingStatus.Open);
        }
        bookingtable.getBooking(bid).setBookingStatus(BookingStatus.Cancelled);
    }



}

