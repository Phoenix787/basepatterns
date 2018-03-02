package com.example.basepatterns.behavioral.strategy.app02.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy{
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;


    /**
     * После проверки карты мы можем совершить оплату. Если клиент продолжает
     * покупки, мы не запрашиваем карту заново.
     */

    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()){
            System.out.println("Paying " + paymentAmount + " using Credit Card.");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }

    /**
     * Собираем данные карты клиента.
     */
    @Override
    public void collectPaymentDetails() {

        System.out.println("Enter card number: ");
        try {
            String number = reader.readLine();
            System.out.println("Enter date 'mm/yy': ");
            String date = reader.readLine();
            System.out.println("Enter cvv code: ");
            String cvv = reader.readLine();

            card = new CreditCard(number, date, cvv);
             //валидируем номер карты

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
