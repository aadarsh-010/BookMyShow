package org.example.services.paymentservice;

public class DebitCard implements PaymentInterface {

    private String debitCardNumber;

    public DebitCard(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("payed an ammout : "+ amount + " via  DEBIT CARD ");
    }

}
