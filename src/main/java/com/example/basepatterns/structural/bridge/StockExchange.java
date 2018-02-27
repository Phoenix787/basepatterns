package com.example.basepatterns.structural.bridge;

public class StockExchange extends Program {
    protected StockExchange(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("StockExchange is in developing...");
        developer.writeCode();
    }
}
