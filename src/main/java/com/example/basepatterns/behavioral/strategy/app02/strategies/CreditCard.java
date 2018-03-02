package com.example.basepatterns.behavioral.strategy.app02.strategies;

public class CreditCard {
    private String number;
    private String date;
    private String cvv;
    private Integer amount;

    public CreditCard(String number, String date, String cvv) {
        this.number = number;
        this.date = date;
        this.cvv = cvv;
        this.amount = 100_000;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
