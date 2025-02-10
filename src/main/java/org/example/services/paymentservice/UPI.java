package org.example.services.paymentservice;

public class UPI implements PaymentInterface{
    private String UPI_ID;

    public UPI(String UPI_ID) {
        this.UPI_ID = UPI_ID;
    }

    @Override
    public void pay(int amount) {
        System.out.println("payed an ammout : "+ amount + " via  UPI ");
    }
}
