package org.example.services.paymentservice;

public class CreditCard implements PaymentInterface{
    private String creditCardNumber;

    public CreditCard(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("payed an ammout : "+ amount + " via  CREDIT CARD ");
    }
}
