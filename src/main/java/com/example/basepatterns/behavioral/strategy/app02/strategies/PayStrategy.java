package com.example.basepatterns.behavioral.strategy.app02.strategies;

/**
 * Общий интерфейс стратегий оплаты
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
