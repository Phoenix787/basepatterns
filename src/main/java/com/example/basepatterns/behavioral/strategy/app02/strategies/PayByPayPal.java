package com.example.basepatterns.behavioral.strategy.app02.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Конкретная стратегия. Реализует оплату корзины интернет магазина через
 * платежную систему PayPal.
 */

public class PayByPayPal implements PayStrategy {

    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signIn;

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.com");
    }

    /**
     * Если клиент уже вошел в систему, то для следующей оплаты данные вводить
     * не придется.
     */

    @Override
    public boolean pay(int paymentAmount) {
        if (signIn){
            System.out.println("Paying " + paymentAmount + " using PayPal");
            return true;
        } else {
            return false;
        }
    }

    /**
     * собираем данные от клиента
     */
    @Override
    public void collectPaymentDetails() {
        try{
            while (!signIn){
                System.out.println("Enter user email: ");
                email = reader.readLine();
                System.out.println("Enter password: ");
                password = reader.readLine();
                if (verify()){
                    System.out.println("Data verification was successful");
                } else {
                    System.out.println("Wrong email or password");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signIn;
    }

    private void setSignedIn(boolean signIn) {
        this.signIn = signIn;
    }
}
