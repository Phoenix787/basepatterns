package com.example.basepatterns.behavioral.strategy.app02.order;

import com.example.basepatterns.behavioral.strategy.app02.strategies.PayStrategy;

public class Order {
    private static int totalCost = 0;
    private boolean isClosed = false;

    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
    }

    public void setTotalCost(int totalCost) {
        Order.totalCost = totalCost;
    }

    public static int getTotalCost() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(){
        isClosed = true;
    }
}
